fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val s = Array(n) { readln() }

    // o の位置を10進数に変換して保持？
    val shop = IntArray(n)
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (s[i][j] =='o') {
                shop[i] = shop[i] or (1 shl j)
            }
        }
    }

    // ??
    var result = n
    for (mask in 0 until (1 shl n)) {
        var o = 0
        for (i in 0 until n) {
            if ((mask shr i) and 1 == 1) {
                o = o or shop[i]
            }
        }
        if (o == (1 shl m) - 1) {
            result = Math.min(result, Integer.bitCount(mask))
        }
    }
    println(result)
}
