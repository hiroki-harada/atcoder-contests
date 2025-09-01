fun main() {
    val (a, b, c, d) = readln().split(" ").map { it.toInt() }

    if (a * 60 + b > c * 60 + d) {
        println("Yes")
    } else {
        println("No")
    }
}
