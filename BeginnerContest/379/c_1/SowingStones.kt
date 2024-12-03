fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val x = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toLong() }

    // 石のマス xi をキー、石の数 ai を値とするペアのリスト(xi で昇順)
    val tmp = mutableListOf<Pair<Long, Long>>()
    for (i in 0 until m) tmp.add(Pair(x[i], a[i]))
    // n マス目を処理するために、ダミーのマスを追加
    tmp.add(Pair(n + 1L, 1L))
    val listStones = tmp.sortedWith(compareBy { it.first })

    var result = 0L
    var curPos = 0L
    var curNumStonesHave = 1L
    for (pair in listStones) {
        // 現在地点から、次に石が置かれているマスまでの距離を求め
        // そのマスまで、1 つずつ石を配置していく
        val distToNextStones = pair.first - curPos
        val stoneHave = curNumStonesHave - distToNextStones

        // 石を一つずつマスに配置するために要した手数を加算
        result += (distToNextStones - 1L) * distToNextStones / 2L
        // 余った石を、現在のマスに移動させるのに要した手数を加算
        result += distToNextStones * stoneHave

        // 石が足りなくなったら、処理終了
        if (stoneHave < 0L) {
            println(-1)
            return
        }

        curPos = pair.first
        curNumStonesHave = stoneHave + pair.second
    }

    // 石が余っていないかを考慮して出力
    if (curNumStonesHave != 1L) println(-1) else println(result)
}
