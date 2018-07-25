import java.io.*
import com.sun.org.apache.xerces.internal.util.DOMUtil.getParent
import java.io.File



fun diffFiles2Cp(){
    var srcFileList = File("/home/kolibreath/githubProject/leetcode/src").list()
    var targetFileList = File("/home/kolibreath/leetcode/code").list()

    //srcFile == srcFilename
        for(srcFile in srcFileList){

            if(srcFile !in targetFileList){
                var srcFullPath = "/home/kolibreath/githubProject/leetcode/src/${srcFile}"
                var tarFullPath = "/home/kolibreath/leetcode/code/${srcFile}"

                cpFile(srcFullPath,tarFullPath)
        }
    }

}

fun cpFile(src:String, tar:String){
    var bufferedReader = BufferedReader(FileReader(src))

    var tarFile = File(tar)
    if(!tarFile.exists()){
        val dir = File(tarFile.getParent())
        dir.mkdirs()
        tarFile.createNewFile()
    }
    var bufferedWriter = BufferedWriter(FileWriter(tarFile))

    for (line in bufferedReader.lines()){

        bufferedWriter.write(line)
        bufferedWriter.newLine()
        bufferedWriter.flush()
    }

}

fun main(args:Array<String>){
    diffFiles2Cp()
}
