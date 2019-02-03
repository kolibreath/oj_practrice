class ContainDuplicates{
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            val set = hashSetOf<Int>()
            for(i in nums)
                set.add(i)
            return set.size != nums.size
        }
    }
}