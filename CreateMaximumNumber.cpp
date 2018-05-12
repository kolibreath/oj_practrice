//
// Created by kolibreath on 18-5-10.
//
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    //1..通过一个栈找到一个数组的最大 最小的组合
//内部需要保持一个下标j 外部维护一个 i作为外部下标

//找到这些数字的时候需要满足这些条件:
//1.需要找到足够多的数字填充这个数组

    vector<int> maxArray(vector<int> &nums,int k){
        int n = nums.size();
        vector<int> result(k);
        for(int i=0,j=0;i<n;i++){
            while(n-i+j>k&&j>0&&result[j-1]<nums[i]) j--;
            if(j<k){
                result[j++] = nums[i];
            }
        }
        return result;
    }

//2如果有特殊情况的话 比如 [6,7] [6,0,4]这种,有数字相同的情况,需要挨个比较直到不相同为止

    bool greater(vector<int>& nums1,int i,vector<int>& nums2,int j){
        while(i<nums1.size() && j< nums2.size() && nums1[i]==nums2[j]){
            i++; j++;
        }
        return j== nums2.size() || (i<nums1.size() && nums1[i]>nums2[j]);
    }

    vector<int> merge(vector<int >& nums1,vector<int> &nums2,int k){
        // int r = 0;
        int i = 0, j=  0;
        vector<int> result(k);
        for(int r=0;r<k;r++){
            if(greater(nums1,i,nums2 ,j)) result[r] = nums1[i++];
            else result[r] = nums2[j++];
        }

        return result ;
    }

    vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
        int m = nums1.size();
        int n = nums2.size();
        vector<int> result(k);
        for (int i = std::max(0 , k - n); i <= k && i <= m; i++){
            auto v1 = maxArray(nums1, i);
            auto v2 = maxArray(nums2, k - i);
            vector<int> candidate = merge(v1, v2, k);
            if (greater(candidate, 0, result, 0)) result = candidate;
        }
        return result;
    }
};


















