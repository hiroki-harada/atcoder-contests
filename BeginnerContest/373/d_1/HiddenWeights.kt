fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val graph = Array<MutableList<Edge>>(n) { mutableListOf<Edge>() }
    repeat(m) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        graph[u - 1].add(Edge(v - 1, w))
        graph[v - 1].add(Edge(u - 1, -w))
    }

    // グラフが複数存在することを考慮して、各点について x が未決定の点を走査する
    val x = LongArray(n) { Long.MAX_VALUE }
    for (i in 0 until n) {
        if (x[i] != Long.MAX_VALUE) continue

        // x は相対値で良いため、起点は -1*10^18 ~ 1*10^18 の間を取って 0 とする
        x[i] = 0L
        dfs(i, graph, x)
    }

    println(x.joinToString(" "))
}


class Edge (val to: Int, val weight: Int)

// from から接続した点について、 x が未決定の点の x を再帰的に決定する
fun dfs(from: Int, graph: Array<MutableList<Edge>>, x: LongArray) {
    for (edge in graph[from]) {
        if (x[edge.to] != Long.MAX_VALUE) continue

        x[edge.to] = x[from] + edge.weight
        dfs(edge.to, graph, x)
    }
}
