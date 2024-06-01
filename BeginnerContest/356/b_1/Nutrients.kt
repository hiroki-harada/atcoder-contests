fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    val nutrients = IntArray(m)
    // 摂取した栄養素を集計
    repeat(n) {
        val x = readln().split(" ").map { it.toInt() }
        for (i in 0 until m) nutrients[i] += x[i]
    }

    // 摂取した栄養素が目標に達しているか確認
    for (i in 0 until m) {
        if (nutrients[i] < a[i]) {
            println("No")
            return
        }
    }
    println("Yes")

}
