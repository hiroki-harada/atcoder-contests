fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }

    // お菓子を渡す順番は結果に影響しないため、ソートして問題ない
    val a = readln().split(" ").map { it.toLong() }.sorted()
    val b = readln().split(" ").map { it.toLong() }.sorted()

    var result = 0L
    var bIdx = 0
    for (ai in a) {
        // 安いお菓子から配り、受け取れる人を探す
        if (ai >= b[bIdx]) {
            result += ai
            bIdx++

            // 全ての人にお菓子を配れた場合
            if (bIdx == m) {
                println(result)
                return
            }
        }
    }

    // 誰か1人でもお菓子を配れない人がいた場合
    println(-1)
}
