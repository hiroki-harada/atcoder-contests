fun main() {
    val (_, c1, c2) = readln().split(" ")
    val s = readln()

    println(s.replace(Regex("[^$c1]"), c2))
}
