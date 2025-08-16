fun main() {
	val q = readln().toInt()

	val balls = IntArray(100)
	for (i in 0 until q) {
		val op = readln().split(" ")

		if (op[0] == "1") {
			balls[op[1].toInt() - 1]++
		}
		if (op[0] == "2") {
			for (j in 0 until 100) {
				if (balls[j] > 0) {
					println(j + 1)
					balls[j]--
					break
				}
			}
		}
	}
}
