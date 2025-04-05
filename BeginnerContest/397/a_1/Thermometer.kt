fun main() {
    val x = readln().toFloat()

    var result = 3
    if (x >= 37.5) result = 2
    if (x >= 38.0) result = 1

    println(result)
}
