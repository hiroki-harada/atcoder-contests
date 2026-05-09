fun main() {
    val n = readln().toInt()

    val a = Array(n) {
        readln().split(" ").map { it.toInt() }.drop(1)
    }

    val (x, y) = readln().split(" ").map { it.toInt() }
    println(a[x - 1][y - 1])
}
