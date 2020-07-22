import kotlin.math.abs
import kotlin.math.max


class Solution {
    private fun depth(root: TreeNode?):Int{
        if(root == null) return 0
        return max(depth(root.left) , depth(root.right) ) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        if(root == null) return true
        val left = depth(root.left)
        val right = depth(root.right)
        if(abs(left - right) > 1) return false
        else return isBalanced(root.left) && isBalanced(root.right)
    }
}