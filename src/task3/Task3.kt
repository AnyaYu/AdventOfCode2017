fun main(args: Array<String>){
    val const = 361527
    var sum: Int = 1
    var amountOfNumbersInRow = 0
    var i = 1
    while (sum<const){
        amountOfNumbersInRow = i*8
        sum += amountOfNumbersInRow
        if (sum>const) {
            sum-=i*8
            break
        }
        i++
    }
    val lastRoundNumber = i
    println("Last round number = " + lastRoundNumber)

    println("The last number in completed round = " + sum)
    val position = const-sum
    println("Position = " + position)

    val inOneSide: Int = (amountOfNumbersInRow+8)/4
    println("Amount of numbers in side = " + inOneSide)

    val middle = sum+inOneSide/2
    println("The middle = " + middle)

    val result = lastRoundNumber+1+const-middle
    println("Result = " + result)
}