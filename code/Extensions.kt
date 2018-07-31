import java.util.ArrayList

fun <T>TestKolibreath.listOf(vararg s:T):ArrayList<T>{
    val arrayList  = ArrayList<T>()

    for(a in s){
        arrayList.add(a)
    }

    return arrayList
}
