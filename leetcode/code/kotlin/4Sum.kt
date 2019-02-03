import java.util.*

class SolutionFourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {

        Arrays.sort(nums)
        var result = ArrayList<ArrayList<Int>>()

        for((index,n) in nums.withIndex()) {
            val alterTarget = target - n
            val values = threeSum(nums, alterTarget, index)

            for (list in values) {
                Collections.sort(list)
                if(list !in result)
                    result.add(list)
            }
        }

        return result
    }

    fun threeSum(sortednums:IntArray,target :Int,i :Int):ArrayList<ArrayList<Int>>{
        var result = ArrayList<ArrayList<Int>>()

        for((index,n) in sortednums.withIndex()){
            if(index !=i ) {
                var alterTarget: Int = (target - n)

                var l = 0
                var h = sortednums.size - 1;

                var list = ArrayList<Int>()

                list.add(n)
                list.add(0-target)

                while (l != h && l != index && h != index) {

                    if ((sortednums[l] + sortednums[h]) < alterTarget) {
                        l++;
                        continue
                    } else if ((sortednums[l] + sortednums[h]) > alterTarget) {
                        h--;
                        continue
                    } else {
                        list.add(sortednums[l])
                        list.add(sortednums[h])
                        result.add(list)

                        break
                    }
                }

            }
        }
        val builder = StringBuilder()

        val test = "something".let{
            val builder = StringBuilder()
            for(i in 0..2){
                builder.append(it.substring(i,i+1)).append(it.substring(i,i+1))
            }
            val some = "fuck" + "fuck"
            builder.toString()
        }

        return result
    }


}
