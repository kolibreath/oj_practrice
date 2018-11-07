import java.util.*

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BinaryTreeZigZagLevelOrderTraveral{
        class Solution {
            fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
                val result = LinkedList<LinkedList<Int>?>()

                zigzagLevelOrder(0,root,result)

                val answer = LinkedList<LinkedList<Int>>()
                result.forEach {
                    answer.add(it!!)
                }
                return answer
            }

            fun zigzagLevelOrder(level:Int,root:TreeNode?,result : LinkedList<LinkedList<Int>?>){
                if(root == null)
                    return
                if(level % 2 == 0){
                    val cur = if( result[level] == null) LinkedList() else result[level]
                    cur!!.add(root.`val`)
                }else{
                    val cur = if( result[level] == null) LinkedList() else result[level]
                    cur!!.push(root.`val`)
                }
                zigzagLevelOrder(level + 1 , root.left,result)
                zigzagLevelOrder(level + 1,root.right,result)
            }
        }
}
