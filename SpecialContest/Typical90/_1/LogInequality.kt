import java.math.BigDecimal

fun main() {
    val input = readln().split(" ")
    val a = input[0].toBigDecimal()
    val b = input[1].toInt()
    val c = input[2].toBigDecimal()

    println(if (a < c.pow(b)) "Yes" else "No")
}
