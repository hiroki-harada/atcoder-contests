import kotlin.math.*

fun main() {
    val n = readln().toInt()
    val s = readln()

    var result = 1
    for (i in 0 until n) {
        if (s[i] != '/') continue

        // / を起点として、外側に向かって文字をチェック
        var currentLength = 1
        for (j in 1 until n / 2 + 1) {
            if (i - j < 0 || i + j >= n) break

            if (s[i - j] == '1' && s[i + j] == '2') {
                currentLength += 2
            } else {
                break
            }
        }
        result = max(result, currentLength)
    }

    println(result)
}
