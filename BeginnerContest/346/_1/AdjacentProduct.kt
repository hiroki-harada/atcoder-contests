fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    val b = IntArray(n-1)
    for (i in 0 until n-1) {
        b[i] = a[i]*a[i+1]
    }

    println(b.joinToString(" "))
}