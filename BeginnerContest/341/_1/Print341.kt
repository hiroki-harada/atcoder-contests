fun main() {
    val n = readln().toInt()

    var result = "1"
    for (i in 1..n) result = result + "01"
    println(result)
}
