fun main() {
    val s = readln()

    // |T| が偶数
    if (s.length % 2 != 0) {
        println("No")
        return
    }

    val cntAlphabet = IntArray(26);
    for (i in 0 until s.length / 2) {
        // T[2i-1] == T[2i]
        if (s[2 * i] != s[2 * i + 1]) {
            println("No")
            return
        }

        cntAlphabet[s.codePointAt(2 * i) - 97]++
        cntAlphabet[s.codePointAt(2 * i + 1) - 97]++
    }

    // 各文字は T にちょうど 0 個または 2 個
    for (cnt in cntAlphabet) {
        if (cnt != 0 && cnt != 2) {
            println("No")
            return
        }
    }

    println("Yes")
}
