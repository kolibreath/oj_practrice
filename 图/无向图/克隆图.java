public class 克隆图{
   class Solution {
        private HashMap<Node, Node> map = new HashMap<>();
        private LinkedList<Node> queue = new LinkedList<>();
        public Node cloneGraph(Node node) {
            if(node == null) return null;
            queue.add(node);
            map.put(node, new Node(node.val, new ArrayList<>()));

            while(!queue.isEmpty()){
                Node cur = queue.poll();
                for(Node nei : cur.neighbors){
                    if(!map.containsKey(nei)){
                        map.put(nei, new Node(nei.val, new ArrayList<>()));
                        queue.add(nei);
                    }
                    map.get(cur).neighbors.add(map.get(nei));
                }
            }
            return map.get(node);
        }
    }
}