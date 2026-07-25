fun main() {
    val (m, d) = readln().split(" ").map { it.toInt() }
    val s = readln()

    // 愚直に探索する
    val notWatched = IntArray(m) { 1 }
    for (i in 0 until m) {
        // 監視されているマスのフラグを折る
        if (s[i] == 'G') {
            for (j in (i - d)..(i + d) ) {
                if (j < 0 || j > m - 1) continue

                notWatched[j] = 0
            }
        }
    }

    println(notWatched.sum())
}
