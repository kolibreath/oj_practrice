class IntersectionOfArray{
    class Solution {
        fun intersect(a: IntArray, b: IntArray): IntArray {
            //in java version thing should be considered like if the nums1 lenght is zero or the nums itself is null
            var pointer1 = 0
            var pointer2 = 0
            val nums1 = a.sorted()
            val nums2 = b.sorted()
            val list = ArrayList<Int>()
            while(pointer1 < nums1.size && pointer2 < nums2.size){
                when {
                    nums1[pointer1] < nums2[pointer2] -> pointer1++
                    nums1[pointer1] > nums2[pointer2] -> pointer2++
                    else -> {
                        list.add(nums1[pointer1])
                        pointer1++
                        pointer2++
                    }
                }
            }

            return IntArray(list.size){
                list[it]
            }
        }
    }
}