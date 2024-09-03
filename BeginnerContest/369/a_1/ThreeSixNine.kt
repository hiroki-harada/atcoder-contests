fun main() {
    // a >= b となるように取得
    val (a, b) = readln().split(" ").map { it.toInt() }.sortedDescending()

    // 1 つのパターン
    if (a == b) {
        println(1)
    } else if ((a - b + 1) / 2 != (a - b) / 2 ) {
        // 2 つのパターン
        println(2)
    } else {
        // 3 つのパターン
        println(3)
    }
}
