fun main() {

    fun returnSet(low : Int,high : Int) : Set<Int>
    {
        val set = mutableSetOf<Int>()
        for (i in low..high) set += i
        return set
    }

    fun part1(input: List<String>): Int {
        var counter = 0
        input.forEach {
            var elfs = it.split(',')
            var shift1 = returnSet(elfs[0].substringBefore('-').toInt(),elfs[0].substringAfter('-').toInt())
            var shift2 = returnSet(elfs[1].substringBefore('-').toInt(),elfs[1].substringAfter('-').toInt())
            if(shift1.intersect(shift2).size == shift1.size || shift1.intersect(shift2).size == shift2.size) counter ++
        }
        return counter
    }


    fun part2(input: List<String>): Int {
        var counter = 0

        input.forEach {
            var elfs = it.split(',')
            var shift1 = returnSet(elfs[0].substringBefore('-').toInt(),elfs[0].substringAfter('-').toInt())
            var shift2 = returnSet(elfs[1].substringBefore('-').toInt(),elfs[1].substringAfter('-').toInt())
            if(shift1.intersect(shift2).isNotEmpty()) counter ++
        }
        return counter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)
    //println(part1(testInput))

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
