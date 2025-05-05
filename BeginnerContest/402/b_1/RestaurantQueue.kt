fun main() {
    val q = readln().toInt()

    val lines = ArrayDeque<Int>()
    for (i in 0 until q) {
        val query = readln().split(" ").map { it.toInt() }

        if (query[0] == 1) {
            lines.add(query[1])
        }
        if (query[0] == 2) {
            println(lines.removeFirst())
        }
    }
}
