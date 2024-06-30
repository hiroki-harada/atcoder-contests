fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val w = readln().split(" ").map { it.toInt() }

    // 箱とその中の荷物をマッピングする
    var mapWeight = mutableMapOf<Int, MutableList<Int>>()
    for (i in 0 until n) {
        var list = mapWeight.getOrElse(a[i]) { mutableListOf<Int>() }
        list.add(w[i])

        mapWeight.put(a[i], list)
    }

    // 荷物が2つ以上入っている箱について、最も重い荷物以外の荷物の重さを合算
    var result = 0
    for (e in mapWeight.entries) {
        if (e.value.size >= 2) {
            result += e.value.sorted().dropLast(1).reduce { sum, cur -> sum+cur }
        }
    }

    println(result)
}
