fun main() {


    fun initialSetup(input: List<String>){

        var i = 0
        var crateList = listOf<MutableList<Char>>()

        while(input.get(i).isNotEmpty())
        {
            var s = input.get(i)

            for (j in 1 .. s.length step 4)
            {
                println(s.get(j))
                var blah = s[j]
                if(s[j].equals(' '))println("hello")
                else{
                    crateList[(j+3)/4] += s[j]
                }
            }

            i++
        }

    }

    fun part1(input: List<String>): Int {

        initialSetup(input)

        return 1
    }



    fun part2(input: List<String>): Int {

        return 2
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == 1)
    //check(part2(testInput) == 2)

    val input = readInput("Day05")
    //println(part1(input))
    //println(part2(input))

}
