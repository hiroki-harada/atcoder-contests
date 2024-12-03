fun main() {
    val s = readln()

    var result = 0L
    // 各文字の出現回数
    val cnt = LongArray(26) { 0L }
    // 各文字のインデックスの累積和
    val sumIdx= LongArray(26) { 0L }

    // si, sk が題意を満たす時、si - sk 間の文字の数を数え上げれば良い
    for (k in 0 until s.length) {
        val code = s[k] - 'A'

        // Σ(k-i-1) = Σ(k-1) - Σi に分解する
        result += (k - 1) * cnt[code] - sumIdx[code]

        cnt[code]++
        sumIdx[code] += k.toLong()
    }

    println(result)
}
