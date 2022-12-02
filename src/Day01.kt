fun main() {

    fun part1(input: List<String>): Int {
        var current = 0
        var max = 0

        input.forEach{
            if(it.isNotEmpty()) current += it.toInt()
            else
            {
                if(current > max) max = current
                current = 0
            }
        }

        return max
    }

    fun part2(input: List<String>): Int {
        var current = 0
        var elfList : MutableList<Int> = mutableListOf()


        input.forEach{
            if(it.isNotEmpty())
            {
                current += it.toInt()
            }
            else
            {
                elfList.add(current)
                current = 0
            }
        }
        elfList.sortDescending()

        return elfList[0] + elfList[1] + elfList[2]
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)
    //println(part1(testInput))

    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}
