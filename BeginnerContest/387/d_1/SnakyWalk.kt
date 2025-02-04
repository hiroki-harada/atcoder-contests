import kotlin.math.*

fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val s = Array<String>(h) { readln() }

    // スタート/ゴールマスを探す
    val (sx, sy) = findPos('S', h, w, s)
    val (gx, gy) = findPos('G', h, w, s)

    var result = Integer.MAX_VALUE
    val moves = arrayOf(
        arrayOf(Pair(0, 1), Pair(0, -1)),
        arrayOf(Pair(1, 0), Pair(-1, 0))
    )

    // 初手の移動について、縦移動/横移動それぞれの場合で BFS を実行
    for (p in 0..1) {
        val distance = Array<IntArray>(h) { IntArray(w) { Integer.MAX_VALUE } }
        val que = ArrayDeque<Pair<Int, Int>>()

        // 初期値を指定
        distance[sx][sy] = 0
        que.add(Pair<Int, Int>(sx, sy))

        // BFS 本体
        while (que.isNotEmpty()) {
            val (i, j) = que.removeFirst()
            for ((di, dj) in moves[(i + j + p) % 2]) {
                val nextI = i + di
                val nextJ = j + dj

                if (nextI !in 0 until h || nextJ !in 0 until w) continue
                if (s[nextI][nextJ] == '#') continue

                // 未訪問マスの距離を更新
                if (distance[nextI][nextJ] == Integer.MAX_VALUE) {
                    distance[nextI][nextJ] = distance[i][j] + 1
                    que.add(Pair(nextI, nextJ))
                }
            }
        }

        result = min(result, distance[gx][gy])
    }

    println(if (result == Integer.MAX_VALUE) -1 else result)
}

// s に含まれる pos の座標 {i, j} を返す
fun findPos(pos: Char, h: Int, w: Int, s: Array<String>): IntArray {
    for (i in 0 until h) {
        for (j in 0 until w) {
            if (s[i][j] != pos) continue

            return intArrayOf(i, j)
        }
    }

    return intArrayOf(-1, -1)
}
