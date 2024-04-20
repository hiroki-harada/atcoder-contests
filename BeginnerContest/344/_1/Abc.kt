fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    val m = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }.toIntArray()
    val l = readln().toInt()
    val c = readln().split(" ").map { it.toInt() }.toIntArray()

    // a, b からぞれぞれ1つ選んだ和 ab を作成
    val ab = mutableListOf<Long>()
    for (i in 0 until n) {
        for (j in 0 until m) ab.add((a[i] + b[j]).toLong())
    }
    ab.sort()

    val q = readln().toInt()
    val x = readln().split(" ").map { it.toInt() }.toIntArray()

    // abi = x - ci を満たす abi が存在するかチェック
    for (i in 0 until q) {
        var isExist = false
        for (j in 0 until l) {
            val xc = (x[i] - c[j]).toLong()
            // xi < c となる xi は除外
            if (xc < 0) continue

            if (ab.binarySearch(xc) >= 0) {
                isExist = true
                break
            }
        }

        println(if (isExist) "Yes" else "No")
    }
}
