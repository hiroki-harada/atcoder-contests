fun main() {
    val n = readln().toInt()
    val a = IntArray(n)
    val b = IntArray(n)
    for (i in 0..n-1) {
        val (ai, bi) = readln().split(" ").map { it.toInt() }
        a[i] = ai
        b[i] = bi
    }

    // 頭の高さと肩の高さの差が一番大きい巨人を一番上に立たせる
    // > Σ(ai) + max(bi-ai) を求める
    var result = 0L
    var max = 0
    for (i in 0..n-1) {
        result += a[i]
        max = Math.max(max, b[i] - a[i])
    }
    result += max

    println(result)
}
