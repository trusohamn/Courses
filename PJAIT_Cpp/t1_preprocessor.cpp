#include <iostream>
//#define POL
//#define ENG
using namespace std;

//prompt for user integer until 0 is entered
//print the number in which the sum of digits is largest
//print in language set in preprocessor macro

int sumNumbers(int num){
    int sum = 0;
    while(num>=1){
        sum += num % 10;
        num /= 10;
    }
    //cout << sum << endl;
    return sum;
}
int main()
{
    string getInfo, outInfo, middle;
    int num, sum, maxNum, maxSum = 0;

    #if defined(POL)
    getInfo = "podaj liczbe naturalna (0 by zakonczyc) ";
    outInfo = "najwieksza suma cyfr to ";
    middle = " dla ";
    #elif defined(ENG)
    getInfo = "enter a natural number (0 if done) ";
    outInfo = "max sum of digits was " ;
    middle = " for ";
    #else
    #error no lanuage specified
    #endif

    while(num!=0){
        cout << getInfo << endl;
        cin >> num;
        sum = sumNumbers(num);
        if(sum>=maxSum){
            maxSum=sum;
            maxNum=num;
        }
    }
    cout << outInfo << maxSum << middle << maxNum << endl;
    return 0;
}
