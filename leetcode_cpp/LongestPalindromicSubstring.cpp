//
// Created by kolibreath on 18-3-24.
//

#include <string>
#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int length = s.length();
        int maxlength = 0, maxstart = 0;
        bool b[length][length];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 1 || i == 0) {
                    b[j][i + j] = (s[j]==s[j+i]);
                } else if (s.at(i + j) == s.at(j)) {
                    b[j][j + i] = b[j+1][j+i- 1];
                } else {
                    b[j][j+i] = false;
                }
                if (b[j][j + i] && i > maxlength) {
                    maxlength = i + 1;
                    maxstart = j;
                }
            }
        }
        return s.substr(maxstart, maxlength + maxstart);
    }
};

int main(){
    Solution solution;
    cout<<solution.longestPalindrome("fafaleveldada");
    return 0;
}
