import kotlin.math.*

fun main() {
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }

    // 尺取り法を使用する
    // l (左端) を一つずつ増やしていって、r (右端)をどこまで伸ばせるか
    // 今回の場合、l は 2 つずつ増やすことになる

    var result = 0
    // 数え上げの開始位置を 2 パターン試す
    for (init in 0..1) {
        val cntAppeared = BooleanArray(n)
        var r = init

        // 開始位置を 2 つずつずらす
        for (l in init until n step 2) {

            while (r + 1 < n) {
                // 同値連続でない場合
                if (a[r] != a[r + 1]) break
                // 既出の場合
                if (cntAppeared[a[r] - 1]) break

                // 2 つ飛ばしで考える
                cntAppeared[a[r] - 1] = true
                r += 2
            }

            result = max(result, r - l)

            // r を一度も動かせなかった場合の考慮
            if (l == r) {
                r += 2
            } else {
                // 左端を削る
                cntAppeared[a[l] - 1] = false
            }
        }
    }

    println(result)
}
