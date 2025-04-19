fun main() {
    val s = readln()
    println(s.replace(Regex("""[a-z]"""), ""))
}
