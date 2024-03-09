fun main() {
    /*
     * _1 と比較して、メモリは倍消費するが、シンプルに解ける
     * https://atcoder.jp/contests/abc344/submissions/me
     */
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }.toIntArray()
    val m = readln().toInt()
    val b = readln().split(" ").map { it.toInt() }.toIntArray()
    val l = readln().toInt()
    val c = readln().split(" ").map { it.toInt() }.toIntArray()

    // 事前に全パターンの合計値を作成する
    val abc = HashSet<Int>()
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (k in 0 until l) {
                abc.add(a[i] + b[j] + c[k])
            }
        }
    }

    val q = readln().toInt()
    val x = readln().split(" ").map { it.toInt() }.toIntArray()
    for (i in 0 until q)  println(if (abc.contains(x[i])) "Yes" else "No")
}
