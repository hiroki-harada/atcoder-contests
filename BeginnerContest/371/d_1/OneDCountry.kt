import kotlin.math.*

fun main() {
    val n = readln().toInt()
    val x = readln().split(" ").map { it.toLong() }
    val p = readln().split(" ").map { it.toLong() }

    // 距離 0 からの村人の人数の総数の累積和を求める
    val cumSumOfP = LongArray(n + 1)
    for (i in 0 until n) cumSumOfP[i + 1] = cumSumOfP[i] + p[i]

    val q = readln().toInt()
    for (i in 0 until q) {
        val (l, r) = readln().split(" ").map { it.toLong() }
        val li = x.binarySearch(l)
        val idxL = if (li >= 0) li else - li - 1
        val ri = x.binarySearch(r)
        val idxR = if (ri >= 0) ri + 1 else - ri - 1

        println(cumSumOfP[idxR] - cumSumOfP[idxL])
    }
}
