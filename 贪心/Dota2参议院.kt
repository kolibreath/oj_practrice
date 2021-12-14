import java.util.*

class Dota2参议院 {
    class Solution {
        fun predictPartyVictory(senate: String): String {
            val radiant = LinkedList<Int>()
            val dire = LinkedList<Int>()
            for(i in senate.indices) {
                if(senate[i] == 'R') radiant.add(i)
                else dire.add(i)
            }
            while(radiant.isNotEmpty() && dire.isNotEmpty()) {
                val radiantIndex = radiant.poll()
                val direIndex = dire.poll()
                if(radiantIndex < direIndex) radiant.add(radiantIndex + senate.length)
                else dire.add(direIndex + senate.length)
            }
            return if(radiant.isNotEmpty()) "Radiant" else "Dire"
        }
    }
}