#  Combination Sum 
这道题是一个求子集的问题，子集中的元素可以重复，这样的话就不应该作为一个排序问题来处理.

````
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    
}
````

如果是求子集的话有一个这样的固定的套路
[reference](https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

递归的思想是这样的，假设需求的list 为 3 0 7 9， 空集合也是子集，所以在开始的进入递归之前就会被加入集合中。在第一次递归的最深处（我的意思是在开始返回上一层之前），这个时候会将整个list中所有元素都会加入结果的数组集合。

然后通过跳过某些元素的方法 求出所有的集合。 需要注意的是，在开始调用递归函数之前可以进行sort sort的目的是在list.add之前减少list判断集合中的元素是否重复耗时，对于这道题，在递归的时候保证remain（剩余值）和重复计算element就ok
