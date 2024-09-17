fun main() {
    val (ab, ac, bc) = readln().split(" ")

    var result = ""
    if (ab == "<") {
        // A < B < C
        if (bc == "<") result = "B"

        if (bc == ">") {
            // A < C < B
            if (ac == "<") result = "C"
            // C < A < B
            if (ac == ">") result = "A"
        }
    }
    if (ab == ">") {
        if (ac == ">") {
            // C < B < A
            if (bc == ">") result = "B"
            // B < C < A
            if (bc == "<") result = "C"
        }
        // B < A < C
        if (ac == "<") result = "A"
    }

    println(result)
}