fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = IntArray(m)
    val b = Array<String>(m) { "" }
    for (i in 0 until m) {
        val (ai, bi) = readln().split(" ")
        a[i] = ai.toInt() - 1
        b[i] = bi
    }

    val isBornEldestSon = BooleanArray(n) { false }
    for (i in 0 until m) {
        // 長男の場合は、出力後にフラグを立てる
        if (b[i] == "M" && !isBornEldestSon[a[i]]) {
            println("Yes")
            isBornEldestSon[a[i]] = true
        } else {
            println("No")
        }
    }
}
