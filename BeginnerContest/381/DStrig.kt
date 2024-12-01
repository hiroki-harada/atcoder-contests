import kotlin.math.*

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    var result = 0

    for (init in 0..1) {
        val isAppeared = BooleanArray(n)
        var rightEdge = init

        for (leftEdge in init until n step 2) {
            while (rightEdge + 1 < n) {
                // 同値判定
                if (a[rightEdge] == a[rightEdge + 1]) break
                // 既出判定
                if (isAppeared[a[rightEdge] - 1]) break

                isAppeared[a[rightEdge] - 1] = true
                // 2 つ飛ばしでチェックする
                rightEdge += 2
            }

            result = max(result, rightEdge - leftEdge)

            if (leftEdge == rightEdge) {
                rightEdge += 2
            } else {
                // 左端の数字を削ってノーカンにする
                isAppeared[a[rightEdge] - 1] = false
            }
        }
    }

    println(result)
}
