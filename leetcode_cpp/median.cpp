#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int size1 = nums1.size();
        int size2 = nums2.size();
        nums1.insert(nums1.end(),nums2.begin(),nums2.end());
        sort(nums1.begin(),nums1.end());
        double median ;
        if((size1+size2)%2==0){
            int number1 = nums1[(size1+size2+1)>>1];
            int number2 = nums1[(size1+size2-1)>>1];
           median =  (double(number1+number2)/2);
        }else{
            median = nums1[(size1+size2)>>1];
        }
        return median;
    }
};

int main(){
    vector<int> num1,num2;
    num1.push_back(1);
    num1.push_back(2);
    num2.push_back(4);
    num2.push_back(3);
    Solution solution;
    cout<<solution.findMedianSortedArrays(num1,num2);
}