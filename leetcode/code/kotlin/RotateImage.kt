class RotateImage{
    class Solution {
        fun rotate(matrix: Array<IntArray>) {
            val size = matrix.size
            for (a in 0 until size) {
                for (b in 0 until size - a) {
                    val c = size - b - 1
                    val d = size - a - 1

                    val temp = matrix[a][b]
                    matrix[a][b] = matrix[c][d]
                    matrix[c][d] = temp
                }
            }

            var low = 0
            var high = size -1
            while(low < high){
                val temp = matrix[low]
                matrix[low] = matrix[high]
                matrix[high] = temp

                low ++
                high--
            }
            for (a in 0 until size) {
                for (b in 0 until size) {
                    print(matrix[a][b].toString() + " ")
                }
                println()
            }
        }
    }
}