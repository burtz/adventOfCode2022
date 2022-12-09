fun main() {

    fun createArray(input: List<String>)
    {
        var numbers = 0
        input.forEach {
            numbers += it.map { it.toString().toInt() } //[1, 2, 3, 4, 5, 6, 7]
        }
        println("hla")
    }


    fun part1(input: List<String>): Int {
        createArray(input)
        return 1
    }

    fun part2(input: List<String>): Int {

        return 2
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day08_test")
    check(part1(testInput) == 1)
    check(part2(testInput) == 2)
    //println(part1(testInput))

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}
