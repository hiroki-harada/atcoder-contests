fun main() {
    val n = readln().toInt()
    val a = Array(n) { IntArray(n) }
    for (i in 0 until n) a[i] = readln().split(" ").map { it.toInt() }.toIntArray()

    val m = readln().toInt()
    val x = IntArray(m)
    val y = IntArray(m)
    for (i in 0 until m) {
        val (xi, yi) = readln().split(" ").map { it.toInt() }
        x[i] = xi
        y[i] = yi
    }



}
