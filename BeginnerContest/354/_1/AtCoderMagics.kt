fun main() {
    val n = readln().toInt()
    // Pair(ai ci) の形式で取得
    val ac = Array(n) { readln().split(" ").map { it.toInt() }.let { it[0] to it[1] } }

    // カードの番号をキー、コストと強さのPairをバリューとするmapを作成
    val mapCards = ac.mapIndexed { index, pair -> index to pair }.toMap()

    // コストの昇順でmapをソート
    val sortedCards = mapCards.toList().sortedBy { it.second.second }

    // 直前のカードより強さが大きいカードの番号を保持
    val remainKeys = mutableListOf<Int>()
    var maxStrength = Int.MIN_VALUE
    for ((index, pair) in sortedCards) {
        val (strength, _) = pair
        if (strength > maxStrength) {
            remainKeys.add(index+1)
            maxStrength = strength
        }
    }

    println(remainKeys.size)
    // remainKeys を昇順に出力
    println(remainKeys.sorted().joinToString(" "))
}
