import kotlin.math.*

fun main() {
    val (n, x, y) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toLong() }
    val b = readln().split(" ").map { it.toLong() }

    val pairTastes = List<Pair<Long, Long>>(n.toInt()) { Pair(a[it], b[it]) }

    // より甘い料理から順番に食べる
    val cntSweetInOrder = cntEatenDishes(x, y, pairTastes.sortedByDescending { it.first })
    // よりしょっぱい料理から順番に食べる
    val cntSaltInOrder = cntEatenDishes(x, y, pairTastes.sortedByDescending { it.second })

    println(min(cntSweetInOrder, cntSaltInOrder))
}

// いずれかの閾値を超えた時時点の、食べた料理の数を返す
fun cntEatenDishes(maxSweet: Long, maxSalt:Long, pairTastes: List<Pair<Long, Long>>): Int {

    var cnt = 0
    var sumSweet = 0L
    var sumSalt = 0L
    for (pair in pairTastes) {
        cnt++
        sumSweet += pair.first
        sumSalt += pair.second
        // 甘さとしょっぱさのどちらかが閾値を超えているか判定
        if (sumSweet > maxSweet || sumSalt > maxSalt) {
            return cnt
        }
    }

    // 全ての料理を食べきった場合
    return cnt
}