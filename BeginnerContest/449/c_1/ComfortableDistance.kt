fun main() {
    val (n, l, r) = readln().split(" ").map { it.toInt() }
    val s = readln()

    // インデックススライディングウィンドウよる解法
    var result = 0L
    // アルファベットの出現回数を管理
    val freqAlphabets = IntArray(26) { 0 }

    // L≤j−i≤R <-> j-R≤i≤j-L
    // j を固定値として、i の取りうる区間から、条件を満たす文字を数え上げる
    for (j in 0 until n) {

        // ウィンドウから出ていく文字
        if (j - r - 1 >= 0) freqAlphabets[s[j - r - 1] - 'a']--
        // ウィンドウに入る文字
        if (j - l >= 0) freqAlphabets[s[j - l] - 'a']++

        // 区間に新しく追加された文字の数を数える
        result += freqAlphabets[s[j] - 'a']
    }

    println(result)
}
