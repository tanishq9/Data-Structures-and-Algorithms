fun main() {
    println(square(10))
    println(squareOneLine1(10))
    println(squareOneLine2(10))
    println(squareOneLine3(10))
    // Positional Arguments
    getMeUser("Tanishq", 22, true)
    // Default Arguments
    getMeUser("Tanishq", 22)
    // Named Arguments
    getMeUser(age = 22, isActive = true, name = "Tanishq")
    // variable length arguments : passed as many values as you want
    countAndPrintArgs(2, 3, 4, 5, 6)
}

// multiple vararg is prohibited in function parameters
fun countAndPrintArgs(vararg number: Int) {
    println(number.size)
}

fun Int.triple(): Int { return this * 3 } var result = 3.triple()

fun a(string: String){

}
fun a(int: Int){

}

var userName: String = "Saluja"

fun getName(): String {
    return "Tanishq"
}

fun square(number: Int): Int {
    return number * number
}

// expression function
fun squareOneLine1(number: Int): Int = number * number
fun squareOneLine2(number: Int) = number * number

// expression function, cannot exceed more than one line for expression function
fun squareOneLine3(number: Int): Int = if (number < 10) number * number else number

/* Type of Arguments
    1. Positional Arguments
    2. Default Arguments
    3. Named Arguments
*/

fun getMeUser(name: String, age: Int, isActive: Boolean = false) {

}