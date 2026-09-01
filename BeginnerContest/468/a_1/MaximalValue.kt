fun main() {
  val n = readln().toInt()
  val a = readln().split(" ").map { it.toInt() }

  var result = 0
  for (i in 0 until n - 2) {
    if (a[i] < a[i + 1] && a[i + 1] > a[i + 2]) result++
  }
  println(result)
}
