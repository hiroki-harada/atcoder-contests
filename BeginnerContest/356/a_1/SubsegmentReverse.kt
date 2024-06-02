fun main() {
    val (n, l, r) = readln().split(" ").map { it.toInt() }

    val result = IntArray(n)
    for (i in 0 until n) result[i] = i+1
    result.reverse(l-1, r)
    println(result.joinToString(" "))
}
