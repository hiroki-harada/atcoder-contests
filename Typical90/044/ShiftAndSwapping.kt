fun main() {
    val (_, q) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }

    val queA = ArrayDeque<Int>(a)
    for (i in 0 until q) {
        val (t, x, y) = readln().split(" ").map { it.toInt() }

        if (t == 1) {
            val tmp = queA.get(x - 1)
            queA.set(x - 1, queA.get(y - 1))
            queA.set(y - 1, tmp)
        }
        if (t == 2) {
            val tmp = queA.removeLast()
            queA.addFirst(tmp)
        }
        if (t == 3) {
            println(queA.get(x - 1))
        }
    }
}
