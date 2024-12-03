fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val s = readln()

    var result = 0
    var cntContinuousTeeth = 0
    for (i in 0 until n) {
        // 連続する歯の数をカウント
        if (s[i] == 'O') {
            cntContinuousTeeth++
        } else {
            cntContinuousTeeth = 0
        }

        // イチゴが食べられるか判定
        if (cntContinuousTeeth == k) {
            result++
            cntContinuousTeeth = 0
        }
    }

    println(result)
}
