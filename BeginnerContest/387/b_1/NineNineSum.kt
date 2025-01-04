fun main() {
    val x = readln().toInt()

    var result = 2025
    for (i in 1..9) {
        for (j in 1..9) {
            if (i * j != x) continue

            result -= i * j
        }
    }

    println(result)
}
