# array相关问题 
其实我觉得数组类型的题目有一点偏智力题，难度不是很高

[Move Zeroes](https://leetcode.com/problems/move-zeroes/description/)

这道题我的想法是使用两个指针，一个指针一直向后扫描，将不是0的数字置换到另外一个指针的位置，然后另外的这个指针再次向后移动，最后在后面全都补上0

但是这里有一个更简单的做法
````
public void moveZeroes(int[] nums) {

    int j = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
    }
}
````

同样是延后一个指针，直接换掉0 和非零数字的位置
