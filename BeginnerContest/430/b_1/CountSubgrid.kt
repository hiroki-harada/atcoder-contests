fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val s = Array<String>(n) { readln() }

    // 全探査で各グリッドを取得する
    val result = HashSet<String>()
    for (y in 0..(n - m)) {
        for (x in 0..(n - m)) {
            // (x, y) グリッドの左端の座標を指定

            // グリッドを切り出して 1 列に結合する
            var grid = ""
            for (i in 0 until m) {
                grid += s[y + i].substring(x, x + m)
            }
            result.add(grid)
        }
    }

    println(result.size)
}
