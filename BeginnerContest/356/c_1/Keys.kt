fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val c = IntArray(m)
    val r = Array<String>(m) { "" }
    val a = Array(m) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val tmp = readln().split(" ")
        c[i] = tmp[0].toInt()
        for (j in 1 until tmp.size-1) a[i].add(tmp[j].toInt())
        r[i] = tmp[tmp.size-1]
    }

    // 全探索で、全てのカギについて、本物と仮定した場合と偽物と仮定した場合を判定する
    var result = 0
    for (mask in 0 until (1 shl n)) { // 0 ~ (1<<n -1) の範囲を全探索

        // j 回目のテスト結果
        var correctPattern = 1
        for (j in 0 until m) {
            // それぞれのカギについて、本物であるカギの本数を算出
            var cntCorrect = 0
            for (aij in a[j]) cntCorrect += (mask shr (aij - 1)) and 1

            // 本物のカギが充分に存在する と ドアが開く の片方のみが成立する場合
            // 矛盾が生じているので、確認を中断
            if ((cntCorrect >= k) != (r[j] == "o")) {
                correctPattern = 0
                break
            }
        }

        result += correctPattern
    }

    println(result)
}
