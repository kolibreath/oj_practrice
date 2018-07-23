# [WordSearch](https://leetcode.com/problems/word-search/description/)
这道题开始的时候我没仔细读题，没有弄懂adajcent的意思，忽略掉了这个细节，于是就将这个board 二维数组 变换成一个一位数组，对存在的字符进行++， 然后再遍历一边整个word


但是如果要考虑临界的情况的话，这个问题变成了一个图问题，需要使用dfs完成

