//
// Created by kolibreath on 18-3-26.
//

#include <iostream>
//#include <basic_string>
#include <vector>
#include <climits>

using namespace std;

class Solution {
public:
    int reverse(int x) {
        if(x>0){
            string value = to_string(x);
            return getReversed(value);
        }else{
            string value = to_string(std::abs(x));
            return 0 - getReversed(value);
        }
    }
    int getReversed(string s) {
        string ret("");
        bool flag = false;
        if (s.length() == 1 && s[0] == '0') {
            ret.push_back(s[0]);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            ret.push_back(s[i]);
        }
        if (stol(ret) > INT_MAX) {
            return 0;
        } else {
            return stol(ret);
        }
    }
};

int main(){
    Solution solution;
    cout<<solution.reverse(100);
    return 0;
}