fun main() {
    val h = readln().toInt()

    var tallOfPlant = 0.0
    var iDay = 0
    while (tallOfPlant <= h) {
        // i 日目夜の成長分を加算
        tallOfPlant += Math.pow(2.0, iDay.toDouble())
        iDay++
    }

    println((iDay).toInt())
}