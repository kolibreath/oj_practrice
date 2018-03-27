#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> answer;
        int i = 0, j = 1;
        for(i;i<nums.size();i++){
            for(j = i+1;j<nums.size();j++){
                if(nums[i] == (target-nums[j])){
                    answer.push_back(i);
                    answer.push_back(j);
                }
            }
        }
        return answer;
    }

    //the 2nd solution
    vector<int> twoSum2(vector<int>&num, int target){
        vector<int> temp ;
        for(int i=0;i<temp.size();i++){
            temp.push_back(i);
        }
        int sum = 0, i= 0, j = num.size()-1;
        while(sum!=target){
            if((num[i]+num[j])==target){
                vector<int> a;
                a.push_back(num[i]);
                a.push_back(num[j]);
                return a;
            }
            if((num[i]+num[j])<target){
                i++;
            }else{
                j--;
            }
        }
    }
};

int main(){
    Solution solution;
    vector<int> vector1;
    vector1.push_back(2);
    vector1.push_back(7);
    vector1.push_back(9);
    vector<int> q = solution.twoSum2(vector1,9);
//    cout<<q.
    return 0;

}