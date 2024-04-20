fun main() {
    val n = readln().toInt()

    var result = ""
    for (i in 1..n) {
        if (i%3 == 0) result += "x"
        else result += "o"
    }

    println(result)
}
