fun main() {
    val (_, k) = readln().split(" ").map { it.toLong() }
    val a = readln().split(" ").map { it.toLong() }.toSet()

    // 1 ~ k の合計値を求め、a に含まれる数字を引く
    var totalK = (1+k)*k/2
    for (ai in a) {
        if (ai <= k) totalK -= ai
    }

    println(totalK)
}