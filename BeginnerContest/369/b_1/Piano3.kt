import kotlin.math.*

fun main() {
    val n = readln().toInt()

    val leftKeys = mutableListOf<Int>()
    val rightKeys = mutableListOf<Int>()
    for (i in 0 until n) {
        val (a, s) = readln().split(" ")

        // 右手/左手に分けて取得
        if (s == "L") leftKeys.add(a.toInt())
        if (s == "R") rightKeys.add(a.toInt())
    }

    var result = 0
    // 左手の演奏の疲労度を算出
    if (leftKeys.size != 0) {
        var latestPos = leftKeys[0]
        for (key in leftKeys) {
            result += abs(key - latestPos)
            latestPos = key
        }
    }
    // 右手の演奏の疲労度を算出
    if (rightKeys.size != 0) {
        var latestPos = rightKeys[0]
        for (key in rightKeys) {
            result += abs(key - latestPos)
            latestPos = key
        }
    }

    println(result)
}
