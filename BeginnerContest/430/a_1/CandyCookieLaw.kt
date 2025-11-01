fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }
    if (c >= a && d < b) {
        println("Yes")
        return
    }
    println("No")
}
