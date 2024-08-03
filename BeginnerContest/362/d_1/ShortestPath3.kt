import java.util.PriorityQueue

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    // 点の重みを奇数番目の辺に設定
    val g = MutableList(2 * n) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until n) g[2 * i].add(Pair(2 * i + 1, a[i]))

    // 辺の重みを偶数番目の辺に設定
    repeat(m) {
        val (u, v, b) = readln().split(" ").map { it.toInt() }
        g[2 * (u - 1) + 1].add(Pair(2 * (v - 1), b))
        g[2 * (v - 1) + 1].add(Pair(2 * (u - 1), b))
    }

    // ダイクストラ法
    val dist = LongArray(2 * n) { Long.MAX_VALUE }
    dist[0] = 0L
    val que = PriorityQueue<Pair<Long, Int>>(compareBy { it.first })
    que.add(Pair(0L, 0))

    while (que.isNotEmpty()) {
        val (d, u) = que.poll()
        if (dist[u] < d) continue

        for ((v, c) in g[u]) {
            if (dist[v] > d + c) {
                dist[v] = d + c
                que.add(Pair(dist[v], v))
            }
        }
    }

    val result = mutableListOf<Long>()
    for (i in 3 until 2 * n step 2) result.add(dist[i])
    println(result.joinToString(" "))
}
