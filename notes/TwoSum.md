# Two Sums 
使用了Kotlin写，然后有列举了两种方法：

> 最佳的方法是使用hash查找 没有更友好的方法了！

- 可以使用Brutal force 通过两层循环找 但是要注意第二个for循环需要避免重复计算第一次for循环中的值    
````
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
````

-   使用hashtable 本质上和第一种没有差别但是hash表做了查询优化，所以速度快了很多
```
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
```