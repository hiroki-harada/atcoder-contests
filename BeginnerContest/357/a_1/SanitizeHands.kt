fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val h = readln().split(" ").map { it.toInt() }

    var result = 0
    var sum = 0
    for (hi in h) {
        sum += hi
        result++

        // 消毒液を使い切ったら処理終了
        if (sum == m) break
        if (sum > m) {
            result--
            break
        }
    }

    println(result)
}
