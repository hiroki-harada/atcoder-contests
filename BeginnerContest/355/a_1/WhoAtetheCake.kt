fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }

    val result = listOf(1, 2, 3).filter { el -> el != a && el != b }

    // 一意に特定出来ればその番号を、出来なければ -1 を出力する
    println( if (result.size == 1) result[0] else -1)
}
