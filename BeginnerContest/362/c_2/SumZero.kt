fun main() {
    val n = readln().toInt()
    val l = LongArray(n)
    val r = LongArray(n)
    for (i in 0 until n) {
        val (li, ri) = readln().split(" ").map { it.toLong() }
        l[i] = li
        r[i] = ri
    }

    // おおよその平均値で初期化
    val x = LongArray(n) { (l[it] + r[it]) / 2L }

    // x がゼロ和数列になるよう調整
    var sum = x.sum()
    for (i in 0 until n) {
        // 合計が 0 になったら打ち切る
        if (sum == 0L) break

        // 可能な限り、最初の項で sum = 0 に近づける
        val newVal = (x[i] - sum).coerceIn(l[i], r[i])
        sum += newVal - x[i]
        x[i] = newVal
    }

    if (sum == 0L) {
        println("Yes")
        println(x.joinToString(" "))
    } else {
        println("No")
    }
}
