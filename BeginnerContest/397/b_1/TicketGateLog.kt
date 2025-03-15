fun main() {
    val s = readln()

    var result = 0

    var isOdd = true
    // 1 文字ずつ走査する
    for (i in 0 until s.length) {
        // 奇数の場合
        if (s[i] == 'i') {
            if (isOdd) {
                isOdd = false
            } else {
                result++
            }
        }

        // 偶数の場合
        if (s[i] == 'o') {
            if (!isOdd) {
                isOdd = true
            } else {
                result++
            }
        }
    }

    if (s[s.length - 1] == 'i') result++

    println(result)
}
