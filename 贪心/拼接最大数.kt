import java.util.*

class 拼接最大数 {
    class Solution {
        fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
            var max = IntArray(k){0}
            for(i in 0..k) {
                val nl1 = i
                val nl2 = k - i
                if(nl1 > nums1.size || nl2 > nums2.size) continue

                // 需要确定从nums1和nums2中至少取多少
                val array1 = maxsubseq(nums1, i)
                val array2 = maxsubseq(nums2, k - i)
                val cur = merge(array1, array2)
                if(compare(cur = cur, _i = 0, max = max, _j = 0) > 0) max = cur
            }
            return max
        }

        fun maxsubseq(nums: IntArray, k: Int): IntArray {
            val sub = IntArray(k)
            val stack = Stack<Int>()
            val n = nums.size
            // stack中最后需要保存k个内容，为了防止将所有的内容pop，需要确定canpop
            var canpop = n - k
            var counter = 0
            for(num in nums) {
                // 删除不合法的num
                while (stack.isNotEmpty() && stack.peek() < num && canpop > 0) {
                    stack.pop()
                    canpop--
                }
                // 将num添加进stack
                stack.push(num)
                counter ++
                if(canpop <= 0) break
            }
            //  将剩余的num放到stack中
            while(counter  < nums.size) stack.push(nums[counter++])
            for(i in sub.indices) sub[i] = stack[i]
            return sub
        }

        fun merge(sub1: IntArray, sub2: IntArray): IntArray {
            val result = IntArray(sub1.size + sub2.size)
            var i1 = 0; var i2 = 0
            var index = 0
            // 如果相等 需要考虑后面的情况
            while(index < result.size) {
                val comp = compare(cur = sub1, _i = i1, max = sub2, _j = i2)
                if(comp > 0)  result[index ++] = sub1[i1++]
                else result[index++] = sub2[i2++]
            }

            return result
        }

        fun compare(cur: IntArray, _i:Int, max: IntArray, _j: Int):Int {
            var i = _i; var j = _j
            while(i < cur.size && j <max.size) {
                val diff = cur[i++] - max[j++]
                if(diff != 0) return diff
            }
            // 如果跳出了while循环 说明 cur和max前面的部分相等，优先从长的部分继续merge
            return (cur.size - i) - (max.size - j)
        }

    }
}

fun main() {
    val solution = 拼接最大数.Solution()
    val nl1 = 2
    val nl2 = 3
    val nums1 = IntArray(nl1) { Random().nextInt(10)}
    val nums2 =  IntArray(nl2) {Random().nextInt(10)}
    while(nums1[0] == 0) nums1[0] = Random().nextInt(10)
    while(nums2[0] == 0) nums2[0] = Random().nextInt(10)

    val k = 5

//    nums1.forEach { print("$it ") }
//    println()
//    nums2.forEach { print("$it ") }
//    println()

    val result = solution.maxNumber(intArrayOf(8,1,8,8,6), intArrayOf(4), 2)
    result.forEach { print("$it ") }
}