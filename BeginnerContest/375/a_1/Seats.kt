fun main() {
    val n = readln().toInt()
    val s = readln().toCharArray()

    var result = 0
    for (i in 1 until n - 1) {
        if (s[i - 1] == '#' && s[i] == '.' && s[i + 1] == '#') result++
    }

    println(result)
}
