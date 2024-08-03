fun main() {
    val n = readln().toInt()
    val l = LongArray(n)
    val r = LongArray(n)
    for (i in 0 until n) {
        val inputs = readln().split(" ").map { it.toLong() }
        l[i] = inputs[0]
        r[i] = inputs[1]
    }

    // 平均値で初期化(切り捨ては一旦考慮しない)
    val x = LongArray(n) { (l[it]+r[it])/2L }

    // 数列 x がゼロ和数列になるよう調整
    var sum = x.sum()
    for (i in 0 until n) {
        // 合計が 0 になったら終了
        if (sum == 0L) break

        // 可能な限り、最初の方の項でゼロ和になるよう平均化する
        val newValue = (x[i] - sum).coerceIn(l[i], r[i])
        sum += newValue - x[i]
        x[i] = newValue
    }

    if (sum == 0L) {
        println("Yes")
        println(x.joinToString(" "))
    } else {
        println("No")
    }
}
