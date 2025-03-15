fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    // a の左から要素数を計算
    val seenPrefix = mutableSetOf<Int>()
    val prefixUnique = IntArray(n)
    for (i in a.indices) {
        seenPrefix.add(a[i])
        prefixUnique[i] = seenPrefix.size
    }

    // a の右から要素数を計算
    val seenSuffix = mutableSetOf<Int>()
    val suffixUnique = IntArray(n)
    for (i in a.indices.reversed()) {
        seenSuffix.add(a[i])
        suffixUnique[i] = seenSuffix.size
    }

    // 最大値の計算
    var result = 0
    for (i in 0 until n - 1) result = maxOf(result, prefixUnique[i] + suffixUnique[i + 1])

    println(result)
}
