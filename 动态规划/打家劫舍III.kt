import kotlin.math.max

class 打家劫舍III {
    class Solution {
        private fun dfs(yes:HashMap<TreeNode,Int>, no:HashMap<TreeNode,Int>, node:TreeNode?){
            if(node == null) return
            dfs(yes, no, node.left)
            dfs(yes, no, node.right)

            yes[node] = node.`val` + no.getOrDefault(node.left,0) + no.getOrDefault(node.right, 0)
            no[node]  = max(yes.getOrDefault(node.left,0 ), no.getOrDefault(node.left, 0)) +
                        max(yes.getOrDefault(node.right, 0), no.getOrDefault(node.right, 0))
        }
        fun rob(root: TreeNode?): Int {
            if(root == null) return 0
            val yes = HashMap<TreeNode, Int>()
            val no = HashMap<TreeNode, Int>()

            dfs(yes,no , root)
            return max(yes[root]!!, no[root]!!)
        }
    }
}