fun main() {
    val (_, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toLong() }

    var result = 1L
    val LIMIT = calcLimit(k)
    for (ai in a) {
        val res = result * ai
        if (res >= LIMIT || res / result != ai) {
            // k + 1 桁以上 or オーバーフローしたらリセット
            result = 1L
        } else {
            result = res
        }
    }

    println(result)
}

fun calcLimit(k: Int): Long {
    var limit = 1L
    repeat(k) { limit *= 10L }
    return limit
}
