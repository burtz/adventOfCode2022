
enum class Moves(val points: Int) {
    Rock(1),
    Paper(2),
    Scissors(3)
}

enum class Result(val points: Int) {
    Win(6),
    Draw(3),
    Lose(0)
}

fun main() {
    // Rules
    // Opponents input: Rock A, Paper B, Scissors C
    // My input : Rock X (1 point), Paper Y (2 points), Scissors Z (3 points)
    // 0 for loss, 3 for draw, 6 for win

    val movesMap = mapOf("A" to Moves.Rock, "B" to Moves.Paper, "C" to Moves.Scissors,
        "X" to Moves.Rock, "Y" to Moves.Paper, "Z" to Moves.Scissors)

    fun winner(myMove:Moves?,oppMove:Moves?) : Int
    {
        if(myMove == Moves.Rock){
            if(oppMove == Moves.Scissors) return Result.Win.points
            if(oppMove == Moves.Rock) return Result.Draw.points
            if(oppMove == Moves.Paper) return Result.Lose.points}
        if(myMove == Moves.Paper){
            if(oppMove == Moves.Rock) return Result.Win.points
            if(oppMove == Moves.Paper) return Result.Draw.points
            if(oppMove == Moves.Scissors)  return Result.Lose.points}
        if(myMove == Moves.Scissors){
            if(oppMove == Moves.Paper) return Result.Win.points
            if(oppMove == Moves.Scissors)  return Result.Draw.points
            if(oppMove == Moves.Rock) return Result.Lose.points}
        println("Error")
        return 0
    }

    fun forced(myMove:String,oppMove:Moves?) : Int
    {
        if(oppMove == Moves.Rock){
            if(myMove == "X") return Result.Lose.points + Moves.Scissors.points
            if(myMove == "Y") return Result.Draw.points + Moves.Rock.points
            if(myMove == "Z") return Result.Win.points + Moves.Paper.points}
        if(oppMove == Moves.Paper){
            if(myMove == "X") return Result.Lose.points + Moves.Rock.points
            if(myMove == "Y") return Result.Draw.points + Moves.Paper.points
            if(myMove == "Z") return Result.Win.points + Moves.Scissors.points }
        if(oppMove == Moves.Scissors){
            if(myMove == "X") return Result.Lose.points + Moves.Paper.points
            if(myMove == "Y") return Result.Draw.points + Moves.Scissors.points
            if(myMove == "Z") return Result.Win.points + Moves.Rock.points }
        println("Error")
        return 0
    }

    fun part1(input: List<String>): Int {

        var currentScore = 0
        input.forEach{
            val myMove = movesMap[it[2].toString()]
            val oppoMove = movesMap[it[0].toString()]
            currentScore += (winner(myMove,oppoMove) + (myMove?.points ?:0 ))
        }
        return currentScore
    }

    fun part2(input: List<String>): Int {
        var currentScore = 0
        input.forEach{
            val myMove = it[2].toString()
            val oppoMove = movesMap[it[0].toString()]
            //println(myMove.toString() + " " + oppoMove.toString() + " " + myMove?.points + " " + winner(myMove,oppoMove))
            currentScore += forced(myMove,oppoMove)
        }
        return currentScore
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    //check(part1(testInput) ==15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}