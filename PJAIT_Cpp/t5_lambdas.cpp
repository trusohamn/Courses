#include <functional>
#include <iostream>

using D2D = std::function<double(double)>;

D2D maxfun(D2D funs[], size_t size, double a, double b, double* pxmax) {
    static constexpr double eps = 1e-6;
    D2D maxF = funs[0];
    double ymax = funs[0](a);

    //iteration through functions
    for(unsigned int i=0; i<size; i++){
       double x = a;
       bool betterF = false; //true if this function has already replaced maxF
        while(x<=b){
            if(funs[i](x)>ymax){
                ymax = funs[i](x);
                *pxmax = x;
                if(!betterF) {
                    betterF = true;
                    maxF = funs[i];
                }
            }
            x+=eps;
        }
    }
    return maxF;
}

int main() {
   D2D myfuncs[]{
        [] (double x) -> double {return -(x*x);},
        [] (double x) -> double {return x*x;},
        //[] (double x) -> double {return 1/x;}
        [] (double x) -> double {return x+10;}
    };
    double xmax2;
    D2D pf2 = maxfun(myfuncs, sizeof(myfuncs)/sizeof(*myfuncs), -4, 3, &xmax2);

    std::cout << "xmax2 = " << xmax2 << "; f(xmax2) = "
              << pf2(xmax2)  << std::endl;


}
