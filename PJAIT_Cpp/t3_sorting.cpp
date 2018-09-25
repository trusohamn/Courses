#include <iostream>
#include <utility> //
using namespace std;
//to make nullptr work -> settings->compiler->-std=c++11

//sorting, ordering
void getMinMax(double &a, double& b, double& c,double*& ptrMin, double*& ptrMax) {
    if(a>=b && a>=c) ptrMax = &a;
    else if  (b>=a && b>=c) ptrMax = &b;
    else ptrMax = &c;

    if(a<=b && a<=c) ptrMin = &a;
    else if  (b<=a && b<=c) ptrMin = &b;
    else ptrMin = &c;
}
void getMinMax(double *a, double* b, double* c, double** ptrMin, double** ptrMax) {
    *ptrMin = a;
    *ptrMax = b;
    if(*a>=*b && *a>=*c) *ptrMax = a;
    else if  (*b>=*a && *b>=*c) *ptrMax = b;
    else *ptrMax = c;

    if(*a<=*b && *a<=*c) *ptrMin = a;
    else if  (*b<=*a && *b<=*c) *ptrMin = b;
    else *ptrMin = c;
}

void ord3(double& a, double& b, double& c) {
    //double temp;
    if(a>b){
        swap(a,b);//temp = a, a = b, b = temp;
    }
    if(a>c){
        swap(a,c); //temp = a, a = c, c = temp;
    }
    if(b>c){
        swap(b,c); //temp = b, b = c, c = temp;
    }
}
void ord3(double* a, double* b, double* c) {
    //double temp;
    if(*a>*b){
        swap(*a,*b);//temp = *a, *a = *b, *b = temp;
    }
    if(*a>*c){
        swap(*a,*c);//temp = *a, *a = *c, *c = temp;
    }
    if(*b>*c){
        swap(*b,*c);//temp = *b, *b = *c, *c = temp;
    }

}
int main() {
    double a, b, c, *ptrMin, *ptrMax;
    a = 3; b = 2; c = 1;
    ord3(a, b, c);
    cout << a << " " << b << " " << c << endl;
    a = 3; b = 2; c = 1;
    ord3(&a, &b, &c);
    cout << a << " " << b << " " << c << endl;
    //4 5 5
    a = 5; b = 5; c = 4;
    ord3(a, b, c);
    cout << a << " " << b << " " << c << endl;
    a = 5; b = 5; c = 4;
    ord3(&a, &b, &c);
    cout << a << " " << b << " " << c << endl;
    //4.2 5.05 5.1
    a = 4.2; b = 5.1; c = 5.05;
    ord3(a, b, c);
    cout << a << " " << b << " " << c << endl;
    a = 4.2; b = 5.1; c = 5.05;
    ord3(&a, &b, &c);
    cout << a << " " << b << " " << c << endl;


    a = 5; b = 0; c = -6;
    ptrMin = ptrMax = nullptr;
    getMinMax(a, b, c, ptrMin, ptrMax);
    cout << "Min = " << *ptrMin << "; "<< "Max = " << *ptrMax << endl;
    //Min = -6; Max = 5
    a = 6; b = 6; c = -6;
    ptrMin = ptrMax = nullptr;
    getMinMax(&a, &b, &c, &ptrMin, &ptrMax);
    cout << "Min = " << *ptrMin << "; "<< "Max = " << *ptrMax << endl;
    //Min = -6; Max = 6
    a = 5.56; b = 0.5; c = 5.55;
    ptrMin = ptrMax = nullptr;
    getMinMax(a, b, c, ptrMin, ptrMax);
    cout << "Min = " << *ptrMin << "; "<< "Max = " << *ptrMax << endl;
    //Min = 0.5; Max = 5.56
    a = 20.2; b = 6000; c = -654;
    ptrMin = ptrMax = nullptr;
    getMinMax(&a, &b, &c, &ptrMin, &ptrMax);
    cout << "Min = " << *ptrMin << "; "<< "Max = " << *ptrMax << endl;
    //Min = -654; Max = 6000
    a = 0; b = 0; c = 0;
    ptrMin = ptrMax = nullptr;
    getMinMax(&a, &b, &c, &ptrMin, &ptrMax);
    cout << "Min = " << *ptrMin << "; "<< "Max = " << *ptrMax << endl;
    //Min = 0; Max = 0

}
