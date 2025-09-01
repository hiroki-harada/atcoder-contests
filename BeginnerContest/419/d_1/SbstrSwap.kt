fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val s = readln()
    val t = readln()

    // 文字列を入れ替える位置にフラグを立て、入れ替えの偶奇を管理する
    val diff = IntArray(n + 1)
    repeat(m) {
        val (l, r) = readln().split(" ").map { it.toInt() }
        diff[l - 1]++
        diff[r]--
    }

    // フラグを起点に、入れ替えが必要な文字は t 側を参照する
    val result = StringBuilder()
    var flip = 0
    for (i in 0 until n) {
        flip += diff[i]
        if (flip % 2 == 0) result.append(s[i])
        else result.append(t[i])
    }

    println(result.toString())
}
