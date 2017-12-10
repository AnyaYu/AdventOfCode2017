package task1

import java.io.File

/**
 * Created by annayushina on 09/12/17.
 */

fun main(args: Array<String>) {
    val myData: List<Int> = File("src/task1/data1.txt").readText().map { it.toString().toInt() }

    //1.1
    val myDataZipWNext = (myData + myData[0]).zipWithNext()
    println("Sum of equals with next = " + sumCount(myDataZipWNext))

    //1.2
    val shift = myData.size / 2
    val newList: List<Int> = myData.indices.map { myData[(it + shift) % myData.size] }
    //or use Collections.rotate()
    val myDataZipWithShift = myData.zip(newList)
    println("Sum of equals with shift = " + sumCount(myDataZipWithShift))

    //another solution for 1.2
    val longList = myData + myData
    val drop = longList.drop(shift)
    println("Sum of equals with shift using drop = " + sumCount(myData.zip(drop)))
}

fun sumCount(myData: List<Pair<Int, Int>>): Int =  myData.filter { it.first == it.second }.map{ it.first }.sum()


