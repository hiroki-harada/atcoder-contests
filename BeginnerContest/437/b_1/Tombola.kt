import kotlin.math.*

fun main() {
    val (h, _, n) = readln().split(" ").map { it.toInt() }
    val a = Array<IntArray>(h) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val b = IntArray(n) { readln().toInt() }

    // 各行に含まれる整数をカウントする
    var result = 0
    for (ai in a) {
        var cnt = 0
        for (bi in b) {
            if (ai.contains(bi)) cnt++
        }
        result = Math.max(result, cnt)
    }

    println(result)
}
