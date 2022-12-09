fun main() {

    fun findMarker(inputString : String, numCheckChars : Int) : Int
    {
        for (i in 0..inputString.length-numCheckChars)
        {
            if(inputString.substring(i,i+numCheckChars).toSet().size > numCheckChars-1) return(i+numCheckChars)
        }
        return 1
    }

    fun part1(input: List<String>): Int {
        return findMarker(input[0],4)
    }

    fun part2(input: List<String>): Int {
        return findMarker(input[0],14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)
    //println(part1(testInput))

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
