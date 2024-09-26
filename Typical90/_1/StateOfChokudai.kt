fun main() {
    val t = readln().toInt()
    val (l, x, y) = readln().split(" ").map { it.toDouble() }
    val q = readln().toInt()
    val e = Array<Int>(q) { readln().toInt() }


    for (i in 0 until q) {
        // ei 分後における観覧車の回転角度 Θ (度)
        val theta = 2*Math.PI * e[i]/t

        // Θ 度回った時の観覧車の座標
        val yi = -l/2 * Math.sin(theta)
        val zi = l/2 - l/2 * Math.cos(theta)

        // 俯角 = atan(horizontal, vertical)
        val vertical = Math.sqrt(Math.pow(x, 2.0) + Math.pow((yi-y), 2.0))
        val horizontal = zi
        val atan = Math.atan2(horizontal, vertical)

        // 度に変換して出力
        println(atan * 180 / Math.PI)
    }
}
