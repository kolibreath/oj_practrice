public class 金字塔转换矩阵 {
   class Solution {
        class Tuple{
            private String key ;
            private String value;
            public Tuple(String key,String value){
                this.key = key; this.value = value;
            }
        }
        private List<Tuple> hash ;
        public boolean pyramidTransition(String bottom, List<String> allowed) {
            hash = hash(allowed);
            return dfs(bottom,"",0);
        }
        private boolean dfs(String bottom,String next,int index){
            if (next.length() == bottom.length() - 1){
                //下一层构建完成
                bottom = next;
                next = "";
                index = 0;
            }
            if(bottom.length() == 1) return true;
            String cur = bottom.substring(index,index+2);
            // 在hash表中寻找可能性
            List<Tuple> pos = new LinkedList<>();
            for (Tuple tuple : hash) {
                if (!tuple.key.equals(cur)) continue;
                pos.add(tuple);
            }
            if (pos.isEmpty()) return false;
            for (Tuple po : pos) {
                if (dfs(bottom, next + po.value, index + 1)) return true;
            }
            return false;
        }

        private LinkedList<Tuple> hash(List<String> allowed){
            LinkedList<Tuple> list = new LinkedList<>();
            for(String str : allowed){
                String key = str.substring(0,2);
                String value = str.substring(2,3);
                list.add(new Tuple(key, value));
            }
            return list;
        }
    }
}