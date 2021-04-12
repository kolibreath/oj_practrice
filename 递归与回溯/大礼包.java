public class 大礼包 {
   class Solution {
        private int min = Integer.MAX_VALUE;
        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            dfs(price, special,needs,new int[needs.size()], 0);
            return min;
        }

        private void dfs(List<Integer> price, List<List<Integer>> packages, List<Integer> needs, int[] holds, int sum){
            // check 是否满足要求
            if (check(needs, holds)) {
                if (sum < min) min = sum;
                return;
            }
            // 存在可以选择大礼包的时候优先考虑大礼包
            for (int i = 0; i < packages.size() ;i ++){
                //尝试当前的大礼包
                int[] temp = copy(holds);
                List<Integer> pakage = packages.get(i);
                boolean flag = false;
                for (int j = 0 ; j < pakage.size() - 1; j++){
                    temp[j] += pakage.get(j);
                    if (temp[j] > needs.get(j)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                dfs(price, packages, needs, temp, sum + pakage.get(pakage.size() -1));
            }

            //没有满足的使用元素补足
            int cur = sum;
            int[] temp = new int[needs.size()];
            for (int i = 0 ; i < needs.size(); i++){
                cur += (needs.get(i)-holds[i]) * price.get(i);
                temp[i] = needs.get(i);
            }
            dfs(price, packages, needs, temp, cur);
        }

        private boolean check(List<Integer> needs, int[] holds){
            for (int i = 0; i<needs.size();i++)
                if (needs.get(i) != holds[i])
                    return false;
            return true;
        }

        private int [] copy(int [] array){
            int[] c = new int[array.length];
            System.arraycopy(array, 0, c, 0, array.length);
            return c;
        }
    }
}