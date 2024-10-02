fun main() {
    val n = 12
    val s = Array<String>(n) { readln() }

    var result = 0
    for (i in 1..n) {
        if (s[i-1].length == i) result++
    }

    println(result)
}
