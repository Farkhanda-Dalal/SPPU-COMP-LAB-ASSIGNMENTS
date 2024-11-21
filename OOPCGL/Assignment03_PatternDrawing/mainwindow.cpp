#include "iostream"
using namespace std;
#include "mainwindow.h"
#include "./ui_mainwindow.h"
QImage img(700,700,QImage::Format_RGB888);//canvas

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    img.fill(Qt::white);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::drawLineDDA(float x1,float y1,float x2,float y2)
{
    float dx,dy,len,x_inc , y_inc, x,y;
    dx=x2-x1;
    dy=y2-y1;
    if (abs(dx)>=abs(dy)){
        len= abs(dx);
    }
    else{
        len = abs(dy);
    }
    x_inc = dx/len;
    y_inc = dy/len;
    int sign;
    if(dx>0){sign =+1;}
    else if(dx==0){sign =0;}
    else{sign=-1;}

    x=x1+0.5*(sign);
    y=y1+0.5*(sign);

    int i=0;
    while(i<len){
        img.setPixel(int(x),int(y),qRgb(255,0,0));
        x=x+x_inc;
        y=y+y_inc;
        i++;
    }
}

void MainWindow::drawCircle(float p, float q, float r)
{
    float d,x,y;
    d=3-2*r;

    x=0;
    y=r;

    while(x<y)
    {
        img.setPixel(x+p,y+q,qRgb(255,0,0));
        img.setPixel(y+p,x+q,qRgb(0,255,0));
        img.setPixel(-y+p,x+q,qRgb(0,0,255));
        img.setPixel(-x+p,y+q,qRgb(0,255,0));
        img.setPixel(-x+p,-y+q,qRgb(255,0,0));
        img.setPixel(-y+p,-x+q,qRgb(0,255,0));
        img.setPixel(y+p,-x+q,qRgb(0,0,255));
        img.setPixel(x+p,q-y,qRgb(0,255,0));

        if(d<0)
        {
            d=d+4*x+6;
            x=x+1;
        }
        else
        {
            d=d+4*(x-y)+10;
            x=x+1;
            y=y-1;
        }

        ui-> drawingArea ->setPixmap(QPixmap::fromImage(img));
    }
}

void MainWindow::drawTraingle(float p, float q, float r1, float r2)
{
    double len = std::sqrt(r1 * r1 - r2 *r2);
    QPointF A(p, q - r1);
    QPointF B(p - len, q + r2);
    QPointF C(p + len, q + r2);

    drawLineDDA(A.x(), A.y(), B.x(), B.y());
    drawLineDDA(B.x(), B.y(), C.x(), C.y());
    drawLineDDA(C.x(), C.y(), A.x(), A.y());


}

void MainWindow::on_innerCircle_clicked()
{
    float p=ui->x->toPlainText().toFloat();
    float q=ui->y->toPlainText().toFloat();
    float r=ui->in->toPlainText().toFloat();

    drawCircle(p,q,r);
}


void MainWindow::on_outerCircle_clicked()
{
    float p=ui->x->toPlainText().toFloat();
    float q=ui->y->toPlainText().toFloat();
    float r=ui->out->toPlainText().toFloat();

    drawCircle(p,q,r);
}


void MainWindow::on_Triangle_clicked()
{
    float p=ui->x->toPlainText().toFloat();
    float q=ui->y->toPlainText().toFloat();
    float r2=ui->in->toPlainText().toFloat();
    float r1=ui->out->toPlainText().toFloat();

    drawTraingle(p,q,r1,r2);

}

