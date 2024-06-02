fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }

    val c = a.plus(b).sorted()

    // 隣接する要素 ci, cj が a に含まれるか、全探索で調べる
    var iGroup = if (a.contains(c[0])) "a" else "b"
    for (i in 1 until n+m) {
        // cj が a, b のどちらに含まれるか確認
        val jGroup = if (a.contains(c[i])) "a" else "b"

        // ci, cj が a に含まれるか確認
        if (iGroup == "a" && jGroup == "a") {
            println("Yes")
            return
        }

        // ci <- cj に移し替え
        iGroup = jGroup
    }

    println("No")
}
