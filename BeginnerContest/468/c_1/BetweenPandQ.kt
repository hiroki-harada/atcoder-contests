var result = 0
var n = 0
var p = listOf<Int>()
var q = listOf<Int>()

fun main() {
    n = readln().toInt()
    p = readln().split(" ").map { it.toInt() }
    q = readln().split(" ").map { it.toInt() }

    // 1 から n までの内で使用済の値を管理する
    val used = BooleanArray(n + 1)
    val current = mutableListOf<Int>()

    dfs(current, used)

    println(result)
}


/**
 * (1..n) の順列を全列挙し、P < 順列 < Q となる個数を [result] に数える。
 *
 * @param current 組み立て中の順列
 * @param used 各数字の使用済みフラグ
 */
fun dfs(current: MutableList<Int>, used: BooleanArray) {

    // 辞書順で p < current < q となるかチェック
    if (current.size == n) {
        if (isLessThan(p, current) && isLessThan(current, q)) result++
        return
    }

    // 要素数が n になるまで、数字を末尾に追加する
    for (i in 1..n) {
        if (!used[i]) {
            current.add(i)
            used[i] = true
            dfs(current, used)

            // 次の走査をするために、末尾の数字をリセット
            val last = current.removeLast()
            used[last] = false
        }
    }
}

/**
 * a よりも b が辞書順として大きいか判定する
 */
fun isLessThan(a: List<Int>, b: List<Int>): Boolean {
    for (i in a.indices) {
        if (a[i] < b[i]) return true
        if (a[i] > b[i]) return false
    }
    return false
}
