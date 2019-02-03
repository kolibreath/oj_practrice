# Count Primes
[原题](https://leetcode.com/problems/count-primes/description/)

这个题用了一种筛子法 处理
Sieve of Eratosthenes

因为从2 开始2的倍数都不是素数，所以2的n倍都不是素数； 同理 3的倍数也不是；4的倍数也不是，但是这个倍数不能从2开始，因为4*2=2*4，在之前已经计算过了。
并且需要标记4不是素数，因为4的n倍在2的时候已经被处理干净了。

````
public class CountPrimes {
    class Solution {
        public int countPrimes(int n) {
            if( n <= 1)
                return 0;
            boolean isPrime[] = new boolean[n];
            for(int i=2;i<n;i++)
                isPrime[i] = true;


            for(int i = 2;i*i<n;i++){
                if(!isPrime[i]) continue;
                for(int j = i*i;j<n;j+=i){
                    isPrime[j] = false;
                }
            }

            int counter = 0;
            for(int i=0;i<n;i++)
                if(isPrime[i])
                    counter ++;

            return counter;
        }
    }
}

````
