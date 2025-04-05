fun main() {
    val s = readln()

    val result = mutableListOf<Char>()

    val matchingBracket = mapOf(
        ')' to '(',
        ']' to '[',
        '>' to '<'
    )

    for (char in s) {
        if (char == '(' || char == '[' || char == '<') {
            // 開きカッコの場合は、スタックに積む
            result.add(char)

        } else if (char == ')' || char == ']' || char == '>') {
            // 閉じカッコの場合は、スタックから取り出してカッコの対応を確認
            if (result.isEmpty() || result.removeAt(result.size - 1) != matchingBracket[char]) {
                // 対応する開きカッコが見つからない場合
                println("No")
                return
            }
        }
    }

    println(if (result.isEmpty()) "Yes" else "No")
}
