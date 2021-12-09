import java.util.*

class 最少数量的箭可以引爆气球 {
    class Solution {
        fun findMinArrowShots(points: Array<IntArray>): Int {
            Arrays.sort(points) { point1, point2 ->
                if(point2[1] < point1[1]) 1 else -1
            }
            var right = points[0][1]
            var counter = 1
            for(i in 1 until points.size) {
                if(right < points[i][0]) {
                    right = points[i][1]
                    counter ++
                }
            }
            return counter
        }
    }
}