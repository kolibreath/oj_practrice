//
// Created by kolibreath on 18-5-6.
//


#include <iostream>
#include <vector>
using namespace std;

class NumArray {
private : vector<int> dp;
public:
    NumArray(vector<int> nums) {
        dp = nums;
        for(int i=1;i<nums.size();i++){
            dp[i] += dp[i-1];
        }
    }

    int sumRange(int i, int j) {
        if(i==0){
            return dp[j];
        }
        return dp[j] - dp[i-1];
    }
};

