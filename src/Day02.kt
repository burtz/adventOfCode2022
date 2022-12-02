
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

    val mapGameScoresP1 = mapOf("A X" to 4, "A Y" to 8, "A Z" to 3, "B X" to 1, "B Y" to 5, "B Z" to 9, "C X" to 7, "C Y" to 2, "C Z" to 6)

    val movesMap = mapOf("A" to Moves.Rock, "B" to Moves.Paper, "C" to Moves.Scissors,
        "X" to Moves.Rock, "Y" to Moves.Paper, "Z" to Moves.Scissors)

    val resultMap = mapOf("X" to Result.Win, "Y" to Result.Draw, "Z" to Result.Lose)

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

    fun response(myMove:Moves?,oppMove:Moves?) : Int {
        if (myMove == Moves.Rock) {
            if (oppMove == Moves.Scissors) return Result.Win.points
            if (oppMove == Moves.Rock) return Result.Draw.points
            if (oppMove == Moves.Paper) return Result.Lose.points
        }
        if (myMove == Moves.Paper) {
            if (oppMove == Moves.Rock) return Result.Win.points
            if (oppMove == Moves.Paper) return Result.Draw.points
            if (oppMove == Moves.Scissors) return Result.Lose.points
        }
        if (myMove == Moves.Scissors) {
            if (oppMove == Moves.Paper) return Result.Win.points
            if (oppMove == Moves.Scissors) return Result.Draw.points
            if (oppMove == Moves.Rock) return Result.Lose.points
        }
        println("Error")
        return 0
    }

    fun part1(input: List<String>): Int {

        var currentScore = 0
        input.forEach{
            val myMove = movesMap[it[2].toString()]
            val oppoMove = movesMap[it[0].toString()]
            //println(myMove.toString() + " " + oppoMove.toString() + " " + myMove?.points + " " + winner(myMove,oppoMove))
            currentScore += (winner(myMove,oppoMove) + (myMove?.points ?:0 ))
        }
        return currentScore
    }

    fun part2(input: List<String>): Int {
        var currentScore = 0
        input.forEach{
            val result = movesMap[it[2].toString()]
            val oppoMove = movesMap[it[0].toString()]
            //println(myMove.toString() + " " + oppoMove.toString() + " " + myMove?.points + " " + winner(myMove,oppoMove))
            currentScore += (winner(myMove,oppoMove) + (myMove?.points ?:0 ))
        }
        return currentScore
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) ==15)
    //check(part2(testInput) == 45000)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}