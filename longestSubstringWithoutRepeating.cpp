//
// Created by kolibreath on 18-3-24.
//
#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        vector<char> stringV;
        int max = s.length()==0?0:1;
        for(int i=0;i<s.length();i++){
            for(int j=0+i;j<s.length();j++){
                if(!contains(stringV,s.at(j))){
                    char c = s.at(j);
                    stringV.push_back(c);
                }else{
                    if(stringV.size()>max){
                        max = stringV.size();
                    }
                    stringV.clear();
                    break;
                }
            }
        }
        return max;
    }

    bool contains(vector<char> stringV,char c){
        for(int i=0;i<stringV.size();i++){
            if(stringV[i]==c){
                return true;
            }
        }
        return false;
    }
};


int main(){
    string string1 = "abcabcbb";
    Solution solution;
    cout<<solution.lengthOfLongestSubstring(string1);
}

