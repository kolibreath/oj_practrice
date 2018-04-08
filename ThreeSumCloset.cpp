//
// Created by kolibreath on 18-4-8.
//
#include <string>
#include <algorithm>
#include <iostream>

using namespace std;
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        if ( nums.size() < 3) return 0;

        sort(nums.begin(),nums.end());
        int closest  = 65535;
        int result = 0;
        for(int k = 0;k<nums.size()-2;k++){
            if(k>0&&nums[k]==nums[k-1])continue;
            int i= k+ 1, j = nums.size() - 1;
            while(i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum>target) {
                    if (sum - target < closest) {
                        closest = sum - target;
                        result = sum;
                    }
                    j--;
                }else if(sum < target) {
                    if (target - sum > closest) {
                    closest = target - sum;
                    result = sum;
                }
                    i++;
                }else if(sum == target){
                   result = sum;
                    return result;
                }
            }
        }
        return result;
    }
};

int main(){
    vector<int> i;
    i.push_back(1);
    i.push_back(1);
    i.push_back(-1);
    Solution solution;
    cout<<solution.threeSumClosest(i,0);
    return 0;
}


