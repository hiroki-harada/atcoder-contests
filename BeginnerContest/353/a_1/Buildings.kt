fun main() {
    val n = readln().toInt()
    val h = readln().split(" ").map { it.toInt() }

    var result = -1
    for (i in 1 until n) {
        if (h[0] < h[i]) {
            result = i+1
            break
        }
    }

    println(result)
}
