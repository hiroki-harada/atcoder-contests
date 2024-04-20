fun main() {
    val a = mutableListOf<Int>();
    while (true) {
        val ai = readln().toInt()
        a.add(ai)
        if (ai == 0) break
    }

    val n = a.size
    for (i in 0 until n) println(a.get(n-1-i))
}
