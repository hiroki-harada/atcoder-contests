fun main() {
    val (_, k) = readln().split(" ").map { it.toInt() }
    val r = readln().split(" ").map { it.toInt() }

    // r を上限とする全ての組み合わせ (permutation) の配列を取得
    var results = mutableListOf<List<Int>>()
    generate(r, mutableListOf(), results)

    for (res in results) {
        // 各配列の総和が k 倍の配列のみ出力
        if (res.sum()%k == 0) println(res.joinToString(" "))
    }
}

fun generate(limits: List<Int>, current: MutableList<Int>, results: MutableList<List<Int>>) {
    if (current.size == limits.size) {
        results.add(current.toList())
        return
    }

    for (i in 1..limits[current.size]) {
        current.add(i)
        generate(limits, current, results)
        current.removeAt(current.size - 1)
    }
}