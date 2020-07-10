import java.util.ArrayDeque;
import java.util.LinkedList;

public class 序列化和反序列化二叉搜索树 {
    public static class Codec {
        private StringBuilder dfs(TreeNode node, StringBuilder sb){
            if(node == null) return sb;
            dfs(node.left, sb);
            dfs(node.right, sb);
            sb.append(node.val);
            sb.append(" ");
            return sb;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null) return "";
            StringBuilder builder = new StringBuilder();
            dfs(root, builder);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }

        private TreeNode createTree(ArrayDeque<Integer> arrayDeque, int lower, int upper){
            if(arrayDeque.isEmpty()) return null;
            int cur = arrayDeque.getLast();
            if(cur < lower || cur > upper) return null;

            arrayDeque.removeLast();
            TreeNode node = new TreeNode(cur);
            node.right = createTree(arrayDeque, cur, upper);
            node.left  = createTree(arrayDeque, lower, cur);
            return node;
        }
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.isEmpty() ) return null;
            ArrayDeque<Integer> values = new ArrayDeque<>();
            String[] chars = data.split(" ");
            for (String s:chars) {
                values.add(s.charAt(0) - '0');
            }
            return createTree(values, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

}