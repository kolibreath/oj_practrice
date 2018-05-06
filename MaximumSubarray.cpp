//
// Created by kolibreath on 18-5-6.
//
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if(nums.size()==0){
            return 0;
        }
        int m = 0;
        vector<int> dp;
        dp.push_back(nums[0]);
        for(int i=1;i<nums.size();i++){
            if(dp[i-1]<0){
                dp.push_back(nums[i]);
                dp[i] = nums[i];
            }else{
                dp.push_back(nums[i]+dp[i-1]);
            }
            m = max(m, dp[i]);
        }
        return m;
    }
};

int main(){
    // [-2,1,-3,4,-1,2,1,-5,4],
    vector<int> v;
    v.push_back(-2);
    v.push_back(1);
    v.push_back(-3);
    v.push_back(4);
    v.push_back(-1);
    v.push_back(2);
    v.push_back(1);
    v.push_back(-5);
    v.push_back(4);

    Solution solution;
    cout<<solution. maxSubArray(v);
    return 0;
}

