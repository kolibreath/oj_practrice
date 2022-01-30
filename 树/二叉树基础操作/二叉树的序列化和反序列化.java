import java.lang.reflect.Array;
import java.util.Arrays;

public class 二叉树的序列化和反序列化 {
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            dfs1(root, builder);
            String s = builder.toString();
            s = s.substring(0, s.length()-1);
            return "[" + s + "]";
        }

        private void dfs1(TreeNode node, StringBuilder builder) {
            // 最后的都好再去掉
            if (node == null) {
                builder.append("null,");
                return;
            }
            builder.append(node.val);
            builder.append(",");
            dfs1(node.left, builder);
            dfs1(node.right, builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.substring(1, data.length()-1);
            String[] values = data.split(",");
            index = 0;
            if (values[0].length() == 0) return null;
            return dfs2(values);
        }

        private int index = 0;
        private TreeNode dfs2(String[]values) {
            if (index >= values.length ) {
                return null;
            }

            if (values[index].equals("null")) {
                index++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(values[index++]));
            node.left = dfs2(values);
            node.right = dfs2(values);
            return node;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        String serial = codec.serialize(node1);
        System.out.println(serial);

        TreeNode root = codec.deserialize(serial);
        String serial_ = codec.serialize(root);
        System.out.println(serial.equals(serial_));
    }
}
