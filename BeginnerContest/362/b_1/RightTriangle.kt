import kotlin.math.*

fun main() {
    val (xa, ya) = readln().split(" ").map { it.toDouble() }
    val (xb, yb) = readln().split(" ").map { it.toDouble() }
    val (xc, yc) = readln().split(" ").map { it.toDouble() }

    // 辺の長さの2乗を求める
    val ab = (xb - xa).pow(2.0) + (yb - ya).pow(2.0)
    val bc = (xc - xb).pow(2.0) + (yc - yb).pow(2.0)
    val ca = (xa - xc).pow(2.0) + (ya - yc).pow(2.0)

    // 三平方の定理が適用できるか確認
    val sides = doubleArrayOf(ab, bc, ca).sorted()
    println(
        if (sides[2] == sides[0] + sides[1]) "Yes" else "No"
    )
}
