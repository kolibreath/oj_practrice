import java.lang.StringBuilder

class 婴儿名字 {
    class Solution {
//        names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
//        synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
        fun trulyMostPopular(names: Array<String>, synonyms: Array<String>): Array<String> {
                val freq = HashMap<String,Int>()
                val parents = HashMap<String, String>()
                for (data in names){
                    val split1 = data.indexOf("(")
                    val split2 = data.indexOf(")")
                    val name = data.substring(0, split1)
                    val frequency = data.substring(split1 + 1,split2)
                    freq[name] = frequency.toInt()
                }

                for (syn in synonyms) {
                    val split = syn.indexOf(",")
                    var name1 = syn.substring(1, split)
                    var name2 = syn.substring(split + 1 , syn.length - 1)
                    //通过两个名字构建并查集
                    while (parents.keys.contains(name1))
                        name1 = parents[name1]!!
                    while (parents.keys.contains(name2))
                        name2 = parents[name2]!!

                    if (name1 == name2) continue

                    //不等于 就需要合并
                    //按照字典顺序 字典顺序小的作为父节点
                    val parent = if (name1 < name2) name1 else name2
                    val son = if (name1 < name2) name2 else name1
                    //直接插入到表中 这里不会出现覆盖的情况 因为找到的name1 或者name2  是最上层的父节点
                    parents[son] = parent
                    freq[parent] = freq.getOrDefault(parent, 0) + freq.getOrDefault(son, 0)
                    freq.remove(son)
                }
                val result = ArrayList<String>()
                for (parent in freq){
                    val builder = StringBuilder("").apply {
                        append(parent.key)
                        append("(")
                        append(parent.value)
                        append(")")
                    }
                    result.add(builder.toString())
                }
                return result.toTypedArray()
        }
    }
}