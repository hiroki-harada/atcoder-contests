import kotlin.math.*

fun main() {
    val colors = readln().split(" ").map { it.toInt() }.toIntArray()
    val c = readln()

    // 嫌いな色を除外する
    if (c == "Red") colors[0] = Int.MAX_VALUE
    if (c == "Green") colors[1] = Int.MAX_VALUE
    if (c == "Blue") colors[2] = Int.MAX_VALUE

    println(colors.min())
}
