
fun nameProcessor(formername:String):String{

    var result = ""
    for(ch in formername){
        when(ch){
             ' ' -> { }

            '-'->{
                result += '_'
            }
            else -> {
                result += ch
            }
        }
    }
    return result
}

fun main(args:Array<String>){
    print(nameProcessor(" N-ary Tree Level Order Traversal"))
}
