import kotlin.math.*

fun main() {
    val n = readln().toInt()

    var result = 0.0
    var x1 = 0.0
    var y1 = 0.0
    // 各座標についてコストを計算
    for (i in 0 until n) {
        val (x2, y2) = readln().split(" ").map { it.toDouble() }
        result += sqrt((x2 - x1).pow(2.0) + (y2 - y1).pow(2.0))

        x1 = x2
        y1 = y2
    }

    // 原点まで戻るコストを足す
    println(result + sqrt(x1.pow(2.0) + y1.pow(2.0)))
}
