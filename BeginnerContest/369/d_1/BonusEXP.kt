fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toLong() }

    // dp[i][j] := i 匹目のモンスターに遭遇し、その時の経験値モードが j(0 or 1) のときの合計経験値
    val dp = Array<LongArray>(n + 1) { LongArray(2) { 0 } }

    // 初期値
    dp[0][1] = 0
    dp[0][0] = Long.MIN_VALUE

    // 漸化式
    for (i in 1 until n) {
        // モンスターを倒さない?
        dp[i + 1][0] = maxOf(dp[i + 1][0], dp[i][0])
        dp[i + 1][1] = maxOf(dp[i + 1][1], dp[i][1])
        // モンスターを倒す?
        dp[i + 1][0] = maxOf(dp[i + 1][0], dp[i][1] + a[i] * 2)
        dp[i + 1][1] = maxOf(dp[i + 1][1], dp[i][0] + a[i])
    }

    println(maxOf(dp[n][0], dp[n][1]))
}
