package task2

import java.io.File

val myData: List<String> = File("src/task2/data").readLines()
val lists: List<List<Int>> = myData.map { it.split("\\s".toRegex()) }.map { list -> list.map { it.toInt() } }


fun main(args: Array<String>) {
    println(getCheckSum(lists))
    println(getCheckSum2(lists))
}

//2.1
fun getCheckSum(lists: List<List<Int>>): Int {
    return  lists
            .map { it.max()!!.minus(it.min()!!) }
            .sum()

}

//2.2
fun getCheckSum2(lists: List<List<Int>>): Int {
    val result = mutableListOf<Int>()
    lists.forEach { l ->
        l.indices.forEach { index ->
            l.forEach { if (l[index]%it==0 && l[index]!=it)result.add(l[index]/it)}
        }
    }
    return  result.sum()

}