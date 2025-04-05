fun main() {
    val s = readln()

    var result = ArrayDeque<Char>()
    result.addFirst(s[s.length - 1])

    // s を後ろから 1 文字ずつチェック
    // WA があれば、 AC に置換した部分文字列をキューに格納
    for (idx in s.length - 2 downTo 0 ) {
        if (s[idx] == 'W' && result.get(0) == 'A') {
            result.removeFirst()
            result.addFirst('C')
            result.addFirst('A')
        } else {
            result.addFirst(s[idx])
        }
    }

    println(result.joinToString(""))
}
