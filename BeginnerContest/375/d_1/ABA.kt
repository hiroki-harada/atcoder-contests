fun main() {
    val s = readln()

    var result = 0L
    val cnt = LongArray(26) { 0L }
    val sum = LongArray(26) { 0L }
    // si, sk が題意を満たす時、si - sk 間の文字の数を数え上げれば良い
    for (i in 0 until s.length) {
        val v = s[i] - 'A'
        result += (i - 1) * cnt[v] - sum[v]
        cnt[v]++
        sum[v] += i.toLong()
    }

    println(result)
}
