import java.util.*
import kotlin.math.floor
import kotlin.random.Random as Random1

class 加油站 {
    class Solution {
        fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
            var i = 0
            while(i < gas.size){
                var counter = 0
                var sumGas = 0
                var sumCost = 0
                while(counter < gas.size) {
                    val j = (i + counter) % gas.size
                    sumGas += gas[j]
                    sumCost += cost[j]
                    if(sumGas < sumCost) break
                    counter ++
                }
                if(counter == gas.size) return i
                else i += counter + 1
            }
            return -1
        }

        fun test(gas: IntArray, cost: IntArray): Int {
            for(i in gas.indices) {
                var cur = i
                var next = (cur+1)%gas.size
                var restGas = gas[cur]
                var flag = true
                var first = true
                while(true) {
                    restGas -= cost[cur]
                    if(restGas < 0) {
                        flag = false
                        break
                    }
                    if(cur == i && !first) break
                    restGas += gas[next]
                    cur = next
                    next = (next+1)%gas.size
                    first = false
                }
                if(flag) return i
            }
            return -1
        }

    }

}

fun main() {
    val solution = 加油站.Solution()
//
//    val gas = IntArray(5){ floor(Random().nextDouble() * 10).toInt() + 1 }
//    val cost = IntArray(5){ floor(Random().nextDouble() * 10).toInt() + 1 }

    val gas = intArrayOf(5,8,2,8)
    val cost = intArrayOf(6,5 ,6,6)
    gas.forEach { print("$it ") }
    println()
    cost.forEach { print("$it ")  }
    println()
    println(solution.canCompleteCircuit(gas, cost))
    println(solution.test(gas, cost))
}
