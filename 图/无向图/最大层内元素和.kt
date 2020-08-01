import java.util.*

class 最大层内元素和 {
    class Solution {
        fun maxLevelSum(root: TreeNode?): Int {
            val queue = LinkedList<TreeNode>()
            if(root == null) return 0
            queue.add(root)
            var max = 0
            var level = 0
            var maxLevel = 0
            while(!queue.isEmpty()){
                level ++
                val size= queue.size
                var count = 0
                for (i in 0 until  size){
                    val node = queue.poll()
                    count += node.`val`
                    if(node.left!= null)
                        queue.add(node.left)

                    if(node.right != null)
                        queue.add(node.right)
                }
                if(count > max){
                    max = count
                    maxLevel = level
                }
            }
            return maxLevel
        }
    }
}