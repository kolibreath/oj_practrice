class TwoSum {
    class Solution {
        //with brutal force
        fun twoSum(nums: IntArray, target: Int): IntArray {
            for(i in nums.indices){
                for(j in i+1 until nums.size){
                    val array = IntArray(2)
                    val sum = nums[i] + nums[j]
                    if(target == sum) {
                        array[0] = i
                        array[1] = j
                        return array
                    }
                }
            }
            return IntArray(0)
        }

        //with hash map
        fun twoSum2(nums:IntArray, target :Int):IntArray{
            val hash = HashMap<Int,Int>()
            for(i in nums.indices){
                if(hash.containsKey(target - nums[i])){
                    val array = IntArray(2)
                    array[0] = i
                    array[1] = hash[target -  nums[i]]!!
                    return array
                }else{
                    hash[nums[i]] = i
                }
            }
            return IntArray(0)
        }
    }
}