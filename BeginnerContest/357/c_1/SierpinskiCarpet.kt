fun main() {
    val n = readln().toInt()

    val carpets = mutableListOf<Array<String>>()
    repeat(n+1) { carpets.add(emptyArray<String>()) }

    val result = getCarpet(n, carpets)
    result.forEach { println(it) }
}


fun getCarpet(n: Int, carpets: MutableList<Array<String>>): Array<String> {
    if (n == 0) {
        carpets[0] = getZero()
        return carpets[0]
    }

    // メモした情報を返す
    if (carpets.size > n && carpets.get(n).size != 0) return carpets[n]

    // レベル n のカーペットを作成する
    val carpet = Array<String>(fac(n)) { "" }

    repeat(3) {
        val lowCarpet = if (n == 0) getZero() else getCarpet(n-1, carpets)
        for (i in 0 until fac(n-1)) {
            // 上段
            carpet[i] += lowCarpet[i]
            // 下段
            carpet[fac(n) - fac(n-1) + i] += lowCarpet[i]
        }
    }

    // 中段
    val lowCarpet = if (n == 0) getZero() else getCarpet(n-1, carpets)
    for (i in 0 until fac(n-1)) carpet[fac(n-1) + i] += lowCarpet[i]
    repeat(fac(n-1)) {
        for (i in 0 until fac(n-1)) carpet[fac(n-1) + i] += "."
    }
    for (i in 0 until fac(n-1)) carpet[fac(n-1) + i] += lowCarpet[i]

    carpets[n] = carpet
    return carpet
}

// レベル 0 のカーペットを返す
fun getZero(): Array<String> = arrayOf("#")

// 3 の n 乗を返す
fun fac(n: Int): Int = Math.pow(3.0, n.toDouble()).toInt()
