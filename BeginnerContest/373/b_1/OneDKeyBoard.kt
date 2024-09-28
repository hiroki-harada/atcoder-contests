import kotlin.math.*

fun main() {
    val s = readln()

    var result = 0
    var prevIdx = s.indexOf('A')
    for (ch in 'B'..'Z') {
        val idx = s.indexOf(ch)
        result += abs(idx - prevIdx)
        prevIdx = idx
    }

    println(result)
}
