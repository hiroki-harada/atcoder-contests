fun main() {
    val (n, a) = readln().split(" ").map { it.toInt() }
    val t = readln().split(" ").map { it.toInt() }

    var result = 0
    for (i in 0 until n) {
        // 自分の前に列があれば、その列が捌けてから、そうでなければ到着後すぐにチケットを買う
        result = if (result > t[i]) result + a else t[i] + a
        println(result)
    }
}
