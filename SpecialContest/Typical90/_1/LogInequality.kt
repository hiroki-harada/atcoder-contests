import kotlin.math.*
import java.math.BigDecimal

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toDouble() }

    println(BigDecimal(log(a, 2.0)))
    println(BigDecimal(b * log(c, 2.0)))
    println(a)
    println(c.pow(b))
    println(if (a < c.pow(b)) "Yes" else "No")
}
