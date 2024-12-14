fun main() {
    val score = readln().split(" ").map { it.toInt() }

    val listPairScores = mutableListOf<Pair<Char, Int>>()
    for (i in 0 until 5) listPairScores.add(Pair('A' + i, score[i]))

    var result = mutableListOf<Pair<String, Int>>()
    // ビット全探索で全パターン生成
    for (i in 1 until (1 shl listPairScores.size)) {
        val chars = StringBuilder()
        var sum = 0
        for (j in listPairScores.indices) {
            if (i and (1 shl j) != 0) {
                chars.append(listPairScores[j].first)
                sum += listPairScores[j].second
            }
        }

        result.add(Pair(chars.toString(), sum))
    }

    result.sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })
        .forEach { println(it.first) }

}
