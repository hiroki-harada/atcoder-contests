fun main() {
    val (w, b) = readln().split(" ").map { it.toInt() }

    // 適当な長さの s を生成する
    val s = "wbwbwwbwbwbw".repeat((w+b)/12+2)

    // s の一部だけ切り取って、W 個の "w" とB 個の "b" から成るか判定
    var result = "No"
    for (i in 0 until s.length-w-b) {
        val si = s.subSequence(i, i+b+w)
        val cntW = si.count { x -> x == 'w' }
        val cntB = si.count { x -> x == 'b' }

        if (cntW == w && cntB == b) {
            result = "Yes"
            break
        }
    }

    println(result)
}
