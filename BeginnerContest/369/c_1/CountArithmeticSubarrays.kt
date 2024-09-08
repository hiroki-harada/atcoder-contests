fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    // n == 1 だけ特殊処理
    if (n == 1) {
        println(1)
        return
    }

    // 最初の項差で初期化
    var currentLength = 1L
    var currentDiff = a[1] - a[0]
    var result = currentLength

    // 配列を一度だけスキャンして、同じ差分が続く最大の部分列を探す
    for (i in 2 until n) {
        val diff = a[i] - a[i - 1]
        if (diff == currentDiff) {
            currentLength++
        } else {
            currentDiff = diff
            currentLength = 1L
        }

        result += currentLength
    }

    // 各要素を長さ 1 の数列として加算
    println(result + n.toLong())
}
