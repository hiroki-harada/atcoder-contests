fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toLong() }.toLongArray()

    // 各国の通貨を 国i -> 国i+1 の流れで交換する
    for (i in 0 until n-1) {
        val (si, ti) = readln().split(" ").map { it.toInt() }

        // 国i の通貨をSi 単位だけ支払い、国(i+1) の通貨をTi 単位だけ獲得
        if (a[i] >= si) a[i+1] += (ti * (a[i]/si)).toLong()
    }

    println(a[n-1])
}
