import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PermutationSequences {
//    static class Solution {
//        public String getPermutation(int n, int k) {
//            int ints[] = converter(n);
//            if(k == 1) {
//                return getString(n);
//            }
//
//            List<Integer> list = new ArrayList<>();
//            permutations(list,ints,0);
//
//            Collections.sort(list);
//
//            return String.valueOf(list.get(k-1));
//        }
//
//        public int[] converter(int n){
//            int result[] = new int[n];
//            for(int i = 0;i<n;i++){
//                result[i] = i+1;
//            }
//                return  result;
//        }
//
//        public String getString(int n){
//            String result = "";
//            for(int i = 1;i<=n;i++)
//                result += i;
//            return result;
//        }
//
//        public void swap(int index1 ,int index2,int src[]){
//            int temp = src[index1];
//            src[index1] = src[index2];
//            src[index2] = temp;
//        }
//
//        public int converter(int src[]){
//            String result = "";
//            for(int i : src)
//                result += i;
//            return Integer.valueOf(result);
//        }
//
//        public void permutations(List<Integer> permutations,int src[] ,int start){
//            if(start >= src.length){
//                permutations.add(converter(src));
//                return;
//            }
//
//            for(int i = start ;i < src.length ; i++){
//                swap(i ,start ,src);
//                permutations(permutations,src,start + 1);
//                swap(i, start, src);
//            }
//        }
//    }

    static class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> num = new LinkedList<Integer>();
            for (int i = 1; i <= n; i++) num.add(i);
            int[] fact = new int[n];  // factorial
            fact[0] = 1;
            for (int i = 1; i < n; i++) fact[i] = i * fact[i - 1];
            k = k - 1;
            StringBuilder sb = new StringBuilder();
            for (int i = n; i > 0; i--) {
                int ind = k / fact[i - 1];
                k = k % fact[i - 1];
                sb.append(num.get(ind));
                num.remove(ind);
            }
            return sb.toString();
        }

    }
}
