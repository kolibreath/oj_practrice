#include<iostream>
#include<string>
//#include"windows.h"
using namespace std;
class CRect {
private:
    string s;//文字
    int width;
    int height;
    int scolor;//文字颜色
    static int count1;//计数
public:
    CRect() {
    }
    CRect(string ss, int w, int h,int c) {
        this->s = ss;
        this->width = w;
        this->height;
        this->scolor = c;

    }
    CRect(CRect &c)//拷贝构造函数
    {
        s = c.s;
        width = c.width;
        height = c.height;
        scolor = c.scolor;
    }
    friend class CPage;//友元类声明
    void showcolor() {
        cout << "白色的字，请输入1" << endl;
        cout << "红色的字，请输入2" << endl;
        cout << "绿色的字，请输入3" << endl;
        cout << "蓝色的字，请输入4" << endl;
        cout << "黄色的字，请输入5" << endl;
        cout << "粉色的字，请输入6" << endl;
        cout << "青色的字，请输入7" << endl;
    }
//    void Setcolor(int n){
//        if(n==1)//白色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
//                                                                     FOREGROUND_GREEN | FOREGROUND_BLUE);
//        if (n == 2)//红色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED);
//        if (n == 3)//绿色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_GREEN);
//        if (n == 4)//蓝色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_BLUE);
//        if (n == 5)//黄色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
//                                                                     FOREGROUND_GREEN);
//        if(n==5)//粉色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
//                                                                     FOREGROUND_BLUE);
//        if(n==6)//青色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_GREEN |
//                                                                     FOREGROUND_BLUE);
//    }
    void setrect() {
        cout << "请输入矩形的宽";
        int w;
        cin >> w;
        cout << "请输入矩形的高";
        int h;
        cin >> h;
        width = w;
        height = h;
        cout << "请输入文字";
        string ss;
        cin >> ss;
        s = ss;
        int c;
        cout << "请输入字体颜色" << endl;
        showcolor();
        cin >> c;
        scolor = c;
    }
    void showRect() {
//        Setcolor(scolor);
        for (int i = 0; i < height; i++)
        {
            if (i == 0 || i == height - 1)
                for (int j = 0; j < width; j++) {
                    cout << "*";
                }
            else
            {
                cout << "*";
                for (int j = 0; j < width - 2; j++) {
                    cout << " ";
                }
                cout << "*";
            }
            cout << "\n";
        }
        cout << s<<endl;
    }
};
class Circle {
private:
    int cirous;//半径
    string s;
    int color;
    static int count2;//计数
public:
    Circle(){}
    Circle(int c, string str,int col) {
        s = str;
        cirous = c;
        color = col;
    }
    Circle(Circle &c) {
        cirous = c.cirous;
        s = c.s;
        color = c.color;
    }
    friend class CPage;//友元类声明
    void showcolor() {
        cout << "白色的字，请输入1" << endl;
        cout << "红色的字，请输入2" << endl;
        cout << "绿色的字，请输入3" << endl;
        cout << "蓝色的字，请输入4" << endl;
        cout << "黄色的字，请输入5" << endl;
        cout << "粉色的字，请输入6" << endl;
        cout << "青色的字，请输入7" << endl;
    }
//    void Setcolor(int n) {
//        if (n == 1)//白色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
//                                                                     FOREGROUND_GREEN | FOREGROUND_BLUE);
//        if (n == 2)//红色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED);
//        if (n == 3)//绿色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_GREEN);
//        if (n == 4)//蓝色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_BLUE);
//        if (n == 5)//黄色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
//                                                                     FOREGROUND_GREEN);
//        if (n == 5)//粉色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_RED |
//                                                                     FOREGROUND_BLUE);
//        if (n == 6)//青色
//            SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), FOREGROUND_INTENSITY | FOREGROUND_GREEN |
//                                                                     FOREGROUND_BLUE);
//    }
    void Setcircle() {
        cout << "请输入圆的半径";
        int c;
        cin >> c;
        cirous = c;
        cout << "请输入文字";
        string str;
        cin >> str;
        s = str;
        showcolor();
        int col;
        cin >> col;
        color = col;
    }
    void Showcircle() {
//        Setcolor(color);
        cout << "\n";
        cout << "圆的半径为" << cirous << endl;
        cout << s << endl;
    }
};
class CPage {
private:
    CRect *r = new CRect[10];//矩形对象数组
    Circle *cir = new Circle[10];//圆数
public:
    CPage(){}
    CPage(CRect rec, Circle c) {
        r[CRect::count1++] = rec;
        cir[Circle::count2++] = c;
    }
    CPage(CRect rec) {
        r[CRect::count1++] = rec;
    }
    CPage(Circle c) {
        cir[Circle::count2++] = c;
    }
    void Setpage() {
        cout << "要多少个矩形";
        int rn;
        cin >> rn;
        for (int i = 0; i < rn; i++) {
            CRect c;
            c.setrect();
            r[CRect::count1++] = c;
        }
        cout << "要多少个圆";
        int cn;
        cin >> cn;
        for (int j = 0; j<cn; j++)
        {
            Circle y;
            y.Setcircle();
            cir[Circle::count2++] = y;
        }
    }
    void ADDcircle(Circle c) {
        cir[Circle::count2++] = c;
    }
    void ADDrect(CRect rec) {
        r[CRect::count1++] = rec;
    }
    void Showpage() {
        cout << "显示圆形："<<endl
                ;
        for (int i = 0; i < Circle::count2; i++)
            cir[i].Showcircle();
        cout << "显示矩形："<<endl;
        for (int j = 0; j < CRect::count1; j++)
            r[j].showRect();
    }
};
int Circle::count2 = 0;
int CRect::count1 = 0;
int main()
{

    Circle c1;
    c1.Setcircle();
    CPage c;
    c.Setpage();
    c.ADDcircle(c1);
    c.Showpage();
    return 0;
}