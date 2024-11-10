fun main() {
    val q = readln().toInt()

    /*
     * 方針
     * 各植物の高さ hi を管理する代わりに何日目に植えたかを管理する
     */
    var iDay = 0L
    val quePlantedAt = ArrayDeque<Long>()
    for (i in 0 until q) {
        val query = readln().split(" ").map { it.toLong() }

        if (query[0] == 1L) {
            // 植物を植える
            quePlantedAt.add(iDay)
        }
        if (query[0] == 2L) {
            // T 日経過させる
            iDay += query[1]
        }
        if (query[0] == 3L) {
            // 高さ H 以上の植物を収穫する
            var result = 0
            while (!quePlantedAt.isEmpty() && iDay - quePlantedAt.first() >= query[1]) {
                quePlantedAt.removeFirst()
                result++
            }
            println(result)
        }
    }
}
