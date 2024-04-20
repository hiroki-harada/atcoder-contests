fun main() {
    val s = readln()

    // 全探索して、全ての部分文字列を求める
    val result = mutableSetOf<CharSequence>()
    for (start in 0..s.length-1) {
        for (end in start+1..s.length) {
            result.add(s.subSequence(start, end))
        }
    }

    println(result.size)
}
