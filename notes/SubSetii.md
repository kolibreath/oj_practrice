# SubSet ii 
这道题中给出一个数组，求出所有可能的sub sets
但是这些subsets不能重复 在顺序上也是
并且给出的数组中可能是有重复的

[1,2,4] == [1,4,2]
发现一种非常好的方法：
## 主要思想
求一个list的subset 等于这个list的所有subset地subset的集合！
[1,2,2] = {[]} + {[1]} + {[2],[1,2]} ... 

- 如果是有duplicate的情况，在之前的基础上构建

但是现在是结果数组中不能有duplicate的情形，比如
[1,2,2] 在第二个三进行计算的时候，不可以再在 {},{1}的基础上面构建 只能从 {2} 的后面构建

```
public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList()); // add []
        for (int i = 0, prev = 0; i < nums.length; i++) {
            int size = ans.size();
                for (int j = (i == 0 || nums[i] != nums[i - 1]) ? 0 : prev; j < size; j++) {
                    List<Integer> cur = new ArrayList(ans.get(j));
                    cur.add(nums[i]);
                    ans.add(cur);
                }
            prev = size;
        }
        return ans;
    }
```
