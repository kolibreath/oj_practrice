import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String args[]){
        List<TreeNode> list = new LinkedList<>();
        TreeNode cur = new TreeNode(10);
        list.add(cur);
        cur=null;
        TreeNode cur2 = list.get(0);

        TreeNode s =new TreeNode(1);
        TreeNode s1 = s;
        s = null;
        System.out.print(s1);
    }
}
