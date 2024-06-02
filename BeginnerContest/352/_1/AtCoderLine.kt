fun main() {
    val (_, x, y, z) = readln().split(" ").map { it.toInt() }

    // x, y, z をソートして、2番目にzが来れば、駅zに停車する
    val lines = listOf(x, y, z).sorted()
    println(if (lines[1] == z) "Yes" else "No")
}