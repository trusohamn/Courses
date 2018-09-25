#include <iostream>
using namespace std;
//reading integers until 0 is entered
//print the length of the longest sequence of the same numbers
int main()
{
    int num, currNum = 0, currCount = 1, maxNum = 0, maxCount = 1;
    cout << "enter a natural number (0 if done) " << endl;
    while(num!=0){
        cin >> num;
        if(num==currNum){
                ++currCount;
        }
        else{
            if(currCount>=maxCount){
                maxNum = currNum;
                maxCount = currCount;
            }
            currNum = num;
            currCount = 1;
        }
    }
    cout << "Longest sequence: " << maxCount << " times number " << maxNum << endl;
    return 0;
}
