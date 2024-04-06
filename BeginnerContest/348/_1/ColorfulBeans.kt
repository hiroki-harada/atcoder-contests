fun main() {
    val n = readln().toInt()
    val a = IntArray(n)
    val c = IntArray(n)
    for (i in 0 until n) {
        val (xi, yi) = readln().split(" ").map { it.toInt() }
        a[i] = xi
        c[i] = yi
    }

    // 各色の最小のおいしさを保持(おいしさの初期値は適当に初期化)
    val mapDelicious = hashMapOf<Int, Int>()
    for (i in 0 until n) {
        val maxIDelicious = mapDelicious.getOrDefault(c[i], Int.MAX_VALUE)
        mapDelicious.put(c[i], Math.min(a[i], maxIDelicious))
    }

    // 各色の中で、最大のおいしさを出力
    println(mapDelicious.maxBy { (_, v) -> v }.value)
}
