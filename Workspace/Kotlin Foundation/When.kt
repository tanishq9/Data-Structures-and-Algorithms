fun main() {
    val any: Any = "Tanishq"
    when (any) {
        "T" -> {
            println("Name1")
        }
        "Tan" -> {
            println("Name2")
        }
        "Tanishq" -> {
            println("Name3")
        }
        else -> {
            println("Name4")
        }
    }

    val x = when (any) {
        "T" -> "Name1"
        "Tan" -> "Name2"
        "Tanishq" -> "Name3"
        else -> "Name4"
    }
    println(x)
}