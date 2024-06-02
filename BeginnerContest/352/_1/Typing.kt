fun main() {
    val s = readln()
    val t = readln()

    // s に含まれる文字を t の先頭から順番に探す
    // 直前に発見した文字の次のインデックスから探索開始
    val result = mutableListOf<Int>()
    var curIndex = 0
    for (si in s.toCharArray()) {

        while (true) {
            // 文字が一致しない場合は次の文字へ
            if (si != t[curIndex]) {
                curIndex++
                continue
            }

            // 文字が一致した場合は、結果に格納
            result.add(++curIndex)
            break
        }
    }

    println(result.joinToString(" "))
}