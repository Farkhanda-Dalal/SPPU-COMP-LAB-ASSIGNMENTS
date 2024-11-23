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

    void Axis(int x1,int y1,int x2,int y2);
    void DDA(int x1,int y1,int x2,int y2);
    int vertices[8];


private slots:
    void on_draw_clicked();

    void on_translation_clicked();

    void on_scaling_clicked();

    void on_rotation_clicked();

private:
    Ui::MainWindow *ui;
};
#endif // MAINWINDOW_H
