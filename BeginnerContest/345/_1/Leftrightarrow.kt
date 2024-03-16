fun main() {
    val s = readln()
    println(if (s.matches(Regex("<=*>"))) "Yes" else "No")
}
