fun main() {
    val x = readln().toLong()

    for (i in 1L..20L) {
        if (factorial(i) != x) continue

        println(i)
        return
    }
}

fun factorial(n: Long): Long {
    if (n == 0L || n == 1L) return 1L
    return n * factorial(n - 1)
}