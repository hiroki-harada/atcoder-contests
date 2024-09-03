fun main() {
    val x = readln()
    // 末尾の .0 or 0 を削除する
    println(x.replace(Regex("""(0{1,}$|\.0{1,}$)"""), ""))
}
