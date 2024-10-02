import kotlin.math.*

fun main() {
    val (a, b) = readln().split(" ").map { it.toLong() }

    val mod = a / gcd(a, b)

    // a * b が Long の上限を超える場合を考慮
    if (mod <= 1_000_000_000_000_000_000L / b) {
        println(mod * b)
    } else {
        println("Large")
    }
}

fun gcd(a: Long, b: Long): Long {
    var dividend = max(a, b);
    val divisor  = min(a, b);
    dividend = dividend.mod(divisor);

    if (dividend == 0L) return divisor;
    return gcd(dividend, divisor);
}
