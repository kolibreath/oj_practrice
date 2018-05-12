import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int amountCopy = amount;
            int value[] = new int[coins.length], key[] = new int[coins.length];
            Arrays.sort(coins);
            for(int i=coins.length-1, j = 0;i>=0;i--, j++) {
                key[j] = coins[i];
                value[i] = 0;
            }
            value[0]=  amountCopy / key[0];
            amountCopy = amountCopy  -value[0] * key[0];
            while(value[0]>0){
                for(int i=1;i<key.length;i++){
                    int valueCopy = amountCopy/key[i];
                    int copy = amountCopy - valueCopy*key[i];

                    if(copy > 0){
                        amountCopy = copy;
                        value[i] = valueCopy;
                    }else if(copy == 0){
                        amountCopy  = copy;
                        value[i] = valueCopy;
                        break;
                    }else {
                        continue;
                    }
                }
            if(amountCopy ==0) break;
                else
                    {value[0] --;
                    amountCopy += key[0];
                    for(int i=1;i<value.length;i++){
                        if(value[i]!=0){
                            amountCopy += value[i]*key[i];
                            value[i]= 0;
                        }
                    }
                }
                
            }
            if(amountCopy!=0){
                return -1;
            }
            int total = 0;
            for(int i=0;i<value.length;i++){
                total += value[i];
            }
            return total;
        }

    }


}
