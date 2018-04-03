//
// Created by kolibreath on 18-4-3.
//

#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;
class Solution {
public:
    string intToRoman(int num) {
        int value[] = {1000, 500, 100, 50, 10, 5, 1};
        char roman[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        string result("");
        for(int i=0;i<7;i += 2){
            int digit = num/value[i];
            num = num - digit*value[i];
            if(digit < 4){
                for(int j=0;j<digit;j++){
                    result += roman[i];
                }
            }else if(digit == 4){
                result += roman[i];
                result += roman[i-1];
            }else if(digit>4&&digit<9){
                result += roman[i-1];
                for(int k=1;k<digit-4;k++){
                    result+=roman[i];
                }
            }else if(digit==9){
                result += roman[i];
                result += +roman[i-2];
            }
        }
        return result;
    }
};

int main(){
    Solution roman;
    cout<<roman.intToRoman(9);
    return 0;
}