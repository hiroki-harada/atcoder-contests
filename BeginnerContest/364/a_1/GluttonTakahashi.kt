fun main() {

    val n = readln().toInt()
    var isEatenSweet = false

    for (i in 1..n) {
        val si = readln()
        if (si == "sweet") {
            // 甘い料理を食べた時
            if (isEatenSweet && i != n) {
                println("No")
                return
            }
            isEatenSweet = true
        } else {
            // 塩辛い料理を食べた時
            isEatenSweet = false
        }
    }

    println("Yes")
}
