fun main() {
    get("Saluja", {
        println(it)
    })
    get("Random") {
        println(it)
    }
}

fun get(name: String, doNothing: (isActive: Boolean) -> Unit): String {
    if (name == "Saluja") {
        doNothing(true)
    } else {
        doNothing(false)
    }
    return "Tanishq $name"
}

