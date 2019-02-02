import com.sun.org.apache.xml.internal.security.utils.Base64
import sun.security.krb5.internal.crypto.Des
import java.io.*

fun encryptFile(src:String){
    val desUtils = DesUtils("kolibreath")
    val tar = src

    val bufferedReader = BufferedReader(FileReader(src))

    val tarFile = File(tar.replace(".md","_encode.md"))
    if(!tarFile.exists()){
        val dir = File(tarFile.getParent())
        dir.mkdirs()
        tarFile.createNewFile()
    }
    val bufferedWriter = BufferedWriter(FileWriter(tarFile))

    for (line in bufferedReader.lines()){

        val newLine = desUtils.encrypt(line)
        bufferedWriter.write(newLine)
        bufferedWriter.newLine()
        bufferedWriter.flush()
    }

    //抹除源文件
    val file = File(src)
    file.delete()
}


fun decryptFile(src:String){
    val desUtils = DesUtils("kolibreath")
    val tar = src

    val bufferedReader = BufferedReader(FileReader(src))

    val tarFile = File(tar.replace("_encode.md",".md"))
    if(!tarFile.exists()){
        val dir = File(tarFile.getParent())
        dir.mkdirs()
        tarFile.createNewFile()
    }
    val bufferedWriter = BufferedWriter(FileWriter(tarFile))

    for (line in bufferedReader.lines()){

        val newLine = desUtils.decrypt(line)
        bufferedWriter.write(newLine)
        bufferedWriter.newLine()
        bufferedWriter.flush()
    }
}
fun main(args: Array<String>) {
    decryptFile("/home/kolibreath/githubProject/Notes/ImCheatSheet/angryLog_encode.md")
    decryptFile("/home/kolibreath/githubProject/Notes/ImCheatSheet/BFsCheatSheet_encode.md")
}
