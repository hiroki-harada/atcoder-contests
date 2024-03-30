fun main() {
    val (_, k) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    val result = mutableListOf<Int>()
    for (ai in a) {
        if (ai%k == 0) result.add(ai/k)
    }

    result.sorted()
    println(result.joinToString(" "))
}