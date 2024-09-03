fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() + 1 }

    var result = "No"
    if (b > c) {
        // 日中に起きている場合
        if (a < b && a > c) result = "Yes"
    } else {
        if (a < b || a > c) result = "Yes"
    }

    println(result)
}
