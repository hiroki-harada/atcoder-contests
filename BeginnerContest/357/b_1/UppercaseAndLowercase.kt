fun main() {
    val s = readln()

    // 大文字と小文字の個数を求める
    val cntUpper = s.filter { Regex("""[A-Z]""").containsMatchIn(it.toString()) }.count()
    val cntLower = s.filter { Regex("""[a-z]""").containsMatchIn(it.toString()) }.count()

    // ケースを変換して出力
    println(if (cntUpper > cntLower) s.uppercase() else s.lowercase() )
}
