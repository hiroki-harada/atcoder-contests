fun main() {
    var (h, w, q) = readln().split(" ").map { it.toInt() }

    while (q-- > 0) {
        val qi = readln().split(" ").map { it.toInt() }

        if (qi[0] == 1) {
            println(qi[1] * w)
            h -= qi[1]
        }
        if (qi[0] == 2) {
            println(h * qi[1])
            w -= qi[1]
        }
    }
}