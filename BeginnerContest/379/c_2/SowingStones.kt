fun main() {
    val (n, m) = readln().split(" ").map { it.toLong() }
    val x = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toLong() }

    // マス xi をキー、石の数 ai をバリューとするペアのリストを作成
    val listTmp = mutableListOf<Pair<Long, Long>>()
    for (i in 0 until m.toInt()) listTmp.add(Pair(x[i], a[i]))
    listTmp.add(Pair(n + 1, 1))
    val listPairStones = listTmp.sortedWith(compareBy { it.first })

    var result = 0L
    var curPos = 0L
    var curNumStonesHave = 1L
    for (pair in listPairStones) {
        // 現在地点から、次に石が置かれているマスまでの距離を求め
        // そのマスまで、1 つずつ石を配置していくことを考える

        val distToNextStones = pair.first - curPos
        val stoneHave = curNumStonesHave - distToNextStones

        // 石が足りなくなったら、その時点で終了
        if (stoneHave < 0L) {
            println(-1)
            return
        }

        // 石を 各マスに配置するための手数
        result += (distToNextStones - 1L) * distToNextStones / 2L
        // 余った石を、現在のマスに移動させるための手数
        result += distToNextStones * stoneHave

        // 次のマスに移動して、現在地と所持石を更新
        curPos = pair.first
        curNumStonesHave = stoneHave + pair.second
    }

    // 石の過不足を考慮して出力
    if (curNumStonesHave == 1L) {
        println(result)
    } else {
        println(-1)
    }
}
