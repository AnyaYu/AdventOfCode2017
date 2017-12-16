package task3

import kotlin.coroutines.experimental.buildSequence
import kotlin.math.abs

fun main(args: Array<String>) {
    val const = 361527
    val listCoordinates = buildSequence {


        var roundNumber = 0
        var side = 0
        var x = 1
        var y = 0
        var size = 0

        while (true) {

            yield(Pair(x, y))
            size++

            if (abs(x) == abs(y)) side++

            if (size == (roundNumber * 2 + 1).let { it * it }) roundNumber++

            if (side == 4) {
                side = 0
                x = roundNumber + 1
                y = roundNumber * (-1) - 1
            }


            when (side) {
                0 -> y++
                1 -> x--
                2 -> y--
                3 -> x++
            }

        }

    }



    val sums = buildSequence<Int> {
        val map = mutableMapOf(Pair(0, 0) to 1)

        for ((x, y) in listCoordinates) {

            var value = 0
            for (i in x - 1..x + 1) {
                for (j in y - 1..y + 1) {
                    value += map.getOrDefault(Pair(i, j), 0)
                }
            }

            yield(value)
            map.put(Pair(x, y), value)
        }
    }

    println(sums.find { it>const })
    println(sums.find { it>const })

}