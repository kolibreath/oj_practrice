//
// Created by kolibreath on 18-4-4.
//

    #include <iostream>
    #include <vector>
    #include <algorithm>

    using namespace std;
    class Solution {
    public:
        vector<vector<int>> threeSum(vector<int>& nums) {
            vector<vector<int >> vector2;
            sort(nums.begin(),nums.end());
            for(int i=0;i<nums.size();i++){
                if(nums[i]>0){
                    break;
                }
                if(i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                int start = 1 + i, end = nums.size()-1 ;
                int sum = 0 - nums[i];
                while(start < end){
                    if(sum==(nums[start]+nums[end])){
                        vector2.push_back({nums[i],nums[start],nums[end]});
                        while(start < end&& nums[start]==nums[start+1]){
                            start++;
                        }
                        while(start < end && nums[end]==nums[end - 1]){
                            end--;
                        }start++, end--;
                    }else if((nums[start] + nums[end])< sum){
                        start++;
                    }else{
                        end --;
                    }
                }
            }
            return vector2;
        }
    };