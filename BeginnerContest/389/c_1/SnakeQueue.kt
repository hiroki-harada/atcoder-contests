fun main() {
    val q = readln().toInt()

    // 追加/削除された累計のヘビの長さを管理する
    var sumOfLength = 0L
    var reduceOfLength = 0L
    val snakeQue = ArrayDeque<Pair<Int, Long>>()

    for (i in 0 until q) {
        val op = readln().split(" ").map { it.toInt() }
        if (op[0] == 1) {
            snakeQue.add(Pair<Int, Long>(op[1], sumOfLength))
            sumOfLength += op[1].toLong()
        }
        if (op[0] == 2) {
            val snake = snakeQue.removeFirst()
            reduceOfLength += snake.first
        }
        if (op[0] == 3) {
            println(snakeQue.get(op[1] - 1).second - reduceOfLength)
        }
    }
}
