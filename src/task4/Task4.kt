package task4

import java.io.File

fun main(args: Array<String>) {
    val myData: List<String> = File("src/task4/data.txt").readLines()

    val listsPf: List<List<String>> = myData.map { it.split(" ") }
    val sorted: List<List<List<Char>>> = listsPf.map { it.map { it.toList().sorted() } }

    val lists = listsPf.map { it.map { it.toList() } }

    println("Result 4_1 = " + getUnique(lists))
    println("Result 4_2 = " + getUnique(sorted))

}

fun getUnique(list: List<List<List<Char>>>): Int = list.filter { it.size == it.toSet().size }.size