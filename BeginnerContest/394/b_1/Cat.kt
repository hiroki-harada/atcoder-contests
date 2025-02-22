fun main() {
    val n = readln().toInt()
    val s = Array(n) { readln() }

    println(s.sortedBy { it.length }.joinToString(""))
}
