fun main() {
    val s = readln()

    println(if (s.matches(Regex(".*R.*M.*"))) "Yes" else "No")
}
