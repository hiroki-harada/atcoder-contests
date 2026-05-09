fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }
    val a = Array(n.toInt()) {
        readln().split(" ").map { it.toInt() }.drop(1)
    }
    val c = readln().split(" ").map { it.toInt() }


    // B を作成すると巨大になるため、Bk を含む整数列 Ai を Ci 回ずつ走査する
    var lenAccumulated = 0L
    for (i in 0 until n.toInt()) {
        val lenAi = a[i].size.toLong()
        val totalLenAi = c[i].toLong() * lenAi

        // Bk を含む整数列 Ai が見つかった場合
        if (lenAccumulated + totalLenAi >= k) {
            val idxInA = ((k - lenAccumulated - 1) % lenAi).toInt()

            println(a[i][idxInA])
            return
        }

        // 見つかってない場合は、走査を続行
        lenAccumulated += totalLenAi
    }
}
