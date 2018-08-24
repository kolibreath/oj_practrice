# Majority Number

这道题是求众数，但是这道题的众数和一般定义的众数不太相同，定义的是要出现数组长度的一半。
有一种很巧妙的做法：通过扫描一遍数组，如果计数器归零，说明这个数字不是众数，如果计数器不为零，但是后面的数字和这个数相同，计数器加一，否则计数器减少1，不是很理解这个做法的原理，但是确实很巧秒

````
public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}
````

一般来说可能需要使用hashset解决
