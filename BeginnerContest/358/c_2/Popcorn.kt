fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val s = Array(n) { readln() }

    // 各売り場の味を、単一の数値に変換
    // oxx -> 1+0+0 = 1
    // oox -> 1+2+0 = 3
    // xoo -> 0+2+4 = 6
    val flavorInShop = IntArray(n)
    for (i in 0 until n) {
        for (j in 0 until m) {
            // (1 shl j)  : 上記の各オペランド算出
            // shop or xx : 上記の + の演算に相当
            if (s[i][j] == 'o') flavorInShop[i] = flavorInShop[i] or (1 shl j)
        }
    }

    var result = n
    // 全売り場に対して、行く or 行かない 場合をbit全探索する
    for (mskshop in 0 until (1 shl n)) {
        var totalFlavor = 0

        for (i in 0 until n) {
            // 売り場i に行く場合、その売り場の全味を数値として加算
            if (((mskshop shr i) and 1) == 1) totalFlavor = totalFlavor or flavorInShop[i]
        }

        // 全ての味を網羅できていたら、その時行った売り場数を保持
        if (totalFlavor == ((1 shl m) - 1)) {
            result = Math.min(result, Integer.bitCount(mskshop))
        }
    }

    println(result)
}
