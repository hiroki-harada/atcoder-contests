fun main() {
    val s = readln()

    // sj を固定して、sj の前後からsi, sk を選ぶことを考える

    // sj を境界として、その両端に存在する各文字の数を管理する
    val cntLeft = IntArray(26) { 0 }
    val cntRight = IntArray(26) { 0 }

    // 初期値指定、全ての文字を右側に含める
    for (i in 0 until s.length) cntRight[i] += s[i] - 'A'

    var result = 0L
    for (i in 0 until s.length) {
        // 右側の左端の 1 文字を取り出す
        cntRight[s[i] - 'A']--

        // 各文字種について、回文となるパターンを集計
        for (ch in 'A'..'Z') {
            result += cntLeft[ch - 'A'] * cntRight[ch - 'A']
        }

        // 取り出した文字を 左端に追加
        cntLeft[s[i] - 'A']++
    }

    println(result)
}
