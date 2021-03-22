import java.io.File
import java.nio.file.Files
import java.util.stream.Collectors
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.nio.file.NoSuchFileException
import java.nio.file.Path
import java.util.*

class Property(
        val file: String,
        val name: String,
        val category: String,
        val value: Int

)

fun main (args: Array<String>){
    if(args.size != 1){
        print("Invalid number of arguments!")
        return

    }
    val projectFolderPath = File(args[0])
    val projectFolderName = args[0].substringAfterLast("\\").substringAfterLast("/")
    val countLength = args[0].substringBeforeLast(projectFolderName).length
    val cppFiles: MutableList<Path>
    try {
        cppFiles = Files.walk(projectFolderPath.toPath())
                .filter { Files.isRegularFile(it) }
                .filter { it.toString().endsWith(".cpp") }
                .collect(Collectors.toList());
    }catch (e:  NoSuchFileException){
        print("File not found")
        return

    }


    if(!projectFolderPath.isDirectory){
        print("Argument is a regular file!")
        return
    }

    val list: MutableList<Property> = LinkedList()
    for(file in cppFiles){
        println(file.toAbsolutePath().toString().substring(countLength))
        list.add(Property(file.toAbsolutePath().toString().substring(countLength),"Number of Methods","Methods",countMehods(file.toString())))

    }

    val gson = GsonBuilder().setPrettyPrinting().create()
    val jsonList: String = gson.toJson(list)
    println(jsonList)
    File("Methods.json").printWriter().use{ out ->
        out.print(jsonList)

    }

}
fun countMehods(file: String): Int {
    val process = ProcessBuilder("ctags","--c++-kinds=f", "--language-force=c++","-x",file).start()
    var result =""
    process.inputStream.reader(Charsets.UTF_8).use {
         result=it.readText()
    }
    if(result.isNullOrEmpty())
        return 0
    else {
        val delimiter = "\n"
        return result.count { delimiter.contains(it) }
    }
}