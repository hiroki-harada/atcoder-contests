fun main() {
    val (a, b, c) = readln().split("").filter { str -> str != "" }

    println("${b}${c}${a} ${c}${a}${b}")
}
