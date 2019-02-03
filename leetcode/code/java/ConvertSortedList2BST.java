public class ConvertSortedList2BST {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null)
                return null;
            return makeNode(head,null);
        }

        TreeNode makeNode(ListNode start,ListNode end){
            if(start == null )
                return null;
            if(start == end){
                return null;
            }

            ListNode fast = start;
            ListNode slow = start;

            while(fast != end && fast.next != end){
                fast = fast.next.next;
                slow = slow.next;
            }
            TreeNode node = new TreeNode(slow.val);
            node.left = makeNode(start,slow);
            node.right = makeNode(slow.next,end);

            return node;
        }
    }
}
