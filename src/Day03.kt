fun main() {

    fun listOfDups(firstComp: List<Char>,secondComp: List<Char>) : List<Char>
    {
        var listOfDupes = listOf<Char>()

        firstComp.forEach { first ->
            secondComp.forEach { second ->
                if (first == second) {
                    listOfDupes += first
                }
            }
        }
        return listOfDupes.distinct()
    }

    fun sumList(input: List<Char>) : Int
    {
        var sum = 0
        input.forEach{
            sum += if(it.code > 96) it.code - 96
            else it.code - 38
        }
        return sum
    }

    fun part1(input: List<String>): Int {

        var listOfDupes = listOf<Char>()

        input.forEach{
            var len = it.length
            var bag = it.toList()

            var firstComp = bag.subList(0,len/2)
            var secondComp = bag.subList(len/2,len)
            listOfDupes += listOfDups(firstComp,secondComp)
        }

        return sumList(listOfDupes)
    }

    fun part2(input: List<String>): Int {
        var listOfBadges = listOf<Char>()

        for (i in 0..input.size-3 step 3) {
            var bag1 = input.get(i).toSet()
            var bag2 = input.get(i+1).toSet()
            var bag3 = input.get(i+2).toSet()

            var zz = bag1.intersect(bag2.intersect(bag3))
            listOfBadges += zz
        }
        return sumList(listOfBadges)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}