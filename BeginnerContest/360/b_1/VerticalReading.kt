fun main() {
    val (s, t) = readln().split(" ")

    // s の先頭から w 文字毎に文字を拾い、 t と一致するか確認する
    for (w in 1 until s.length) {

        // 開始位置を指定
        for (c in 1..w) {
            var idx = c - 1

            var jointed = ""
            while (idx < s.length) {
                jointed += s[idx]
                idx += w
            }

            if (jointed == t) {
                println("Yes")
                return
            }
        }
    }

    println("No")
}
