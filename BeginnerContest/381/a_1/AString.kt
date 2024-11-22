fun main() {
    val n = readln().toInt()
    val s = readln()

    // 特殊パターン
    if (s == "/") {
        println("Yes")
        return
    }

    if (n % 2 != 1) {
        println("No")
        return
    }

    for (i in 0 until (n - 1) / 2) {
        if (s[i] != '1') {
            println("No")
            return
        }
    }

    if (s[(n - 1) / 2] != '/') {
        println("No")
        return
    }

    for (i in (n - 1) / 2 + 1 until n) {
        if (s[i] != '2') {
            println("No")
            return
        }
    }

    println("Yes")
}
