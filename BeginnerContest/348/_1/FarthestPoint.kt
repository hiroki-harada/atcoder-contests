fun main() {
    val n = readln().toInt()
    val x = IntArray(n)
    val y = IntArray(n)
    for (i in 0 until n) {
        val (xi, yi) = readln().split(" ").map { it.toInt() }
        x[i] = xi
        y[i] = yi
    }

    // (xi, yi) からの距離が最大である点の番号をそれぞれ求める
    val result = IntArray(n)
    val maxDistance = IntArray(n)
    for (i in 0 until n) {
        for (j in 0 until n) {

            // より距離が大きい点の番号とその距離を保持する
            val iDistance = Math.pow((x[i]-x[j]).toDouble(), 2.0) + Math.pow((y[i]-y[j]).toDouble(), 2.0)
            if (iDistance > maxDistance[i]) {
                result[i] = j + 1
                maxDistance[i] = iDistance.toInt()
            }
        }
    }

    println(result.joinToString("\n"))
}
