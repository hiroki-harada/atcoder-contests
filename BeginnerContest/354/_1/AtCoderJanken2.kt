fun main() {
    val n = readln().toInt()
    val s = Array<String>(n) { "" }
    val c = IntArray(n)
    for (i in 0 until n) {
        val (si, ci) = readln().split(" ")
        s[i] = si
        c[i] = ci.toInt()
    }

    // レートの合計を算出
    val t = c.reduce { prev, current -> prev+current }

    // ユーザ名を辞書順に並べ、T mod n のインデックスをもつユーザ名を出力
    println(
        s.sorted()[Math.floorMod(t, n)]
    )
}