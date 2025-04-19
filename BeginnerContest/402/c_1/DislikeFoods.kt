fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    // 各食材が何回使われたか集計
    val mapCntMaterials = mutableMapOf<Int, MutableList<Int>>()
    val k = IntArray(m)
    repeat(m) { i ->
        val parts = readln().split(" ").map { it.toInt() }
        k[i] = parts[0]
        val a = parts.subList(1, k[i] + 1)
        for (ai in a) mapCntMaterials.getOrPut(ai) { mutableListOf() }.add(i)
    }

    val b = readln().split(" ").map { it.toInt() }


    val cntCanEatDay = IntArray(n)
    val canEat = BooleanArray(m)

    for (iDay in 0 until n) {
        // 該当の食材が使われていれば、処理開始
        val dishes = mapCntMaterials[b[iDay]] ?: continue

        for (iDish in dishes) {
            // 既出はスキップ
            if (canEat[iDish]) continue

            k[iDish]--
            if (k[iDish] == 0) {
                cntCanEatDay[iDay]++
                canEat[iDish] = true
            }
        }
    }

    // 前日に食べられるようになった料理数を加算して出力
    var sum = 0
    repeat(n) { i ->
        sum += cntCanEatDay[i]
        println(sum)
    }
}
