fun main() {
    val (n, t) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    val isOpen = BooleanArray(n * n) { false }

    for (i in 0 until t) {
        // 宣言した整数にチェック
        val ai = a[i] - 1
        isOpen[ai] = true

        // ビンゴの行が存在するか判定
        if (isBingoRow(isOpen, ai, n)) {
            println(i + 1)
            return
        }
        // ビンゴの列が存在するか判定
        if (isBingoColumn(isOpen, ai, n)) {
            println(i + 1)
            return
        }

        // 斜めのビンゴが存在するか判定
        if (isBingoCross(isOpen, ai, n)) {
            println(i + 1)
            return
        }
    }

    println(-1)
}

fun isBingoRow(isOpen: BooleanArray, ai: Int, n: Int): Boolean {
    // ai が存在する行のみ走査
    val row = ai / n
    for (j in 0 until n) {
        if (!isOpen[row * n + j]) return false
    }
    return true
}

fun isBingoColumn(isOpen: BooleanArray, ai: Int, n: Int): Boolean {
    // ai が存在する列のみ走査
    val col = ai % n
    for (i in 0 until n) {
        if (!isOpen[i * n + col]) return false
    }
    return true
}

fun isBingoCross(isOpen: BooleanArray, ai: Int, n: Int): Boolean {
    // 左上から右下への対角線をチェック
    if (ai % (n + 1) == 0) {
        var bingo = true
        for (i in 0 until n) {
            if (!isOpen[i * n + i]) {
                bingo = false
                break
            }
        }
        if (bingo) return true
    }

    // 右上から左下への対角線をチェック
    if (ai != 0 && ai % (n - 1) == 0 && ai != n * n - 1) {
        var bingo = true
        for (i in 0 until n) {
            if (!isOpen[i * n + (n - 1 - i)]) {
                bingo = false
                break
            }
        }
        if (bingo) return true
    }

    return false
}
