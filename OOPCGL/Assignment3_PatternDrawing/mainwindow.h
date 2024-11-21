#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();



private slots:

    void drawLineDDA(float x1,float y1,float x2,float y2);
    void drawCircle(float p, float q, float r);
    void drawTraingle(float p, float q, float r1,float r2);


    void on_innerCircle_clicked();

    void on_outerCircle_clicked();

    void on_Triangle_clicked();

private:
    Ui::MainWindow *ui;
    float p, q, r,r1,r2,C,A,B,len,x1, y1, x2,y2;
    int d;
};
#endif // MAINWINDOW_H
