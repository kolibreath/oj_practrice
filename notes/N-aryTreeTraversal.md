# N-aryTreeTraversal

- preorder
````
 class Solution {
        public List<Integer> preorder(Node root) {
            if(root == null)
                return new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            preorder(root,result);

            return result;
        }

        public void preorder(Node root, List<Integer> list){
            if(root == null)
                return;
            list.add(root.val);
            if(root.children!=null)
                for(int i=0;i<root.children.size();i++){
                    preorder(root.children.get(i),list);
                }
        }
    }
````

- postorder
当然是要等所有的children节点完成遍历再加入list
```
class Solution {
        public List<Integer> postorder(Node root) {
            if(root == null)
                return new ArrayList<>();
            
            List<Integer> list = new ArrayList<>();
            postorder(root,list);
            return list;
        }

        public void postorder(Node root, List<Integer> list){
            if(root == null) {
                return;
            }
            if(root.children!=null) {
                for (int i = 0; i < root.children.size(); i++) {
                    postorder(root.children.get(i), list);
                }
            }
            list.add(root.val);
        }
    }
```

必须会的是非递归写法：
使用非递归写法有待那类似于BFS,先将一些节点储存在一个stack中，但是存储的顺序需要颠倒
```
  class Solution {
        public List<Integer> postorder(Node root) {
            if (root == null)
                return new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Node node = stack.pop();
                list.add(node.val);
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
            return list;
        }
    }
```
