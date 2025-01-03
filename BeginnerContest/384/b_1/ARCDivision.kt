fun main() {
    val (n, r) = readln().split(" ").map { it.toInt() }

    var result = r
    for (i in 0 until n) {
        val (d, a) = readln().split(" ").map { it.toInt() }

        if (d == 1) {
            if (result >= 1600 && result <= 2799) result += a
        }
        if (d == 2) {
            if (result >= 1200 && result <= 2399) result += a
        }
    }

    println(result)
}
