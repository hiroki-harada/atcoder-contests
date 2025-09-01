import kotlin.math.*

fun main() {
    val n = readln().toInt()

    // チェビシェフ距離の最大 / 2 を求める
    var minX = Long.MAX_VALUE
    var maxX = Long.MIN_VALUE
    var minY = Long.MAX_VALUE
    var maxY = Long.MIN_VALUE
    repeat(n) {
        val (x, y) = readln().split(" ").map { it.toLong() }
        minX = min(minX, x)
        maxX = max(maxX, x)
        minY = min(minY, y)
        maxY = max(maxY, y)
    }

    println(
        max((maxX - minX + 1) / 2, (maxY - minY + 1) / 2 )
    )
}
