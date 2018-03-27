//
// Created by kolibreath on 18-3-21.
//
#include <algorithm>
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int hammingDistance(int x, int y) {
        vector<int> xs = Convert(x);
        vector<int> ys = Convert(y);
    }

    //convert the bits and sort decendent
    vector<int> Convert(int number){
        vector<int> bits;
        while(number/2!=0){
            bits.push_back(number%2);
            number /= 2;
        }
        return sort(bits.begin(),bits.end());
    }
};

