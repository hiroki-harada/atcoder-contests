fun main() {
    val (h, w) = readln().split(" ").map { it.toInt() }
    val (si, sj) = readln().split(" ").map { it.toInt() }
    val c = Array<CharArray>(h) { CharArray(w) }
    for (i in 0 until h) c[i] = readln().toCharArray()

    val X = readln().toCharArray()

    // 初期値を 0 始まりに補正
    var x = si - 1
    var y = sj - 1
    for (xi in X) {
        // 左
        if (xi == 'L' && y > 0 && c[x][y - 1] == '.') y -= 1
        // 右
        if (xi == 'R' && y < w - 1 && c[x][y + 1] == '.') y += 1
        // 上
        if (xi == 'U' && x > 0 && c[x - 1][y] == '.') x -= 1
        // 下
        if (xi == 'D' && x < h - 1 && c[x + 1][y] == '.') x += 1
    }

    // 1 始まりに補正して出力
    println("${x + 1} ${y + 1}")
}
