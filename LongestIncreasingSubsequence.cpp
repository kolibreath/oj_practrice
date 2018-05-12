#include <vector>
#include <iostream>
using namespace std;


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int > vector1(nums.size(), 1);
        int result = 0;
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<i;j++) {
                if (nums[i] > nums[j]) {
                    vector1[i] = max(vector1[i],vector1[j]+1);
                }
            }
            result = max(result,vector1[i]);
        }
        return result;
    }
};