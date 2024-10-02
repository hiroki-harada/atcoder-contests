fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toLong() }

    // dp[i][j] := i 匹目のモンスターに遭遇し、その時の経験値モードが j(0 or 1) のときの合計経験値
    val dp = Array<LongArray>(n + 1) { LongArray(2) { Long.MIN_VALUE } }

    // 初期値
    dp[0][0] = 0L

    // 漸化式
    for (i in 0 until n) {
        for (j in 0..1) {
            // モンスターを逃がす(倒さない)前後での、最大経験値を求める
            dp[i + 1][j] = maxOf(dp[i + 1][j], dp[i][j])
            // モンスターを倒す前後での、最大経験値を求める
            dp[i + 1][1 - j] = maxOf(dp[i + 1][1 - j], dp[i][j] + a[i] * (j + 1))
        }
    }

    println(dp[n].max())
}
