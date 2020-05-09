// Constructing Arrays using Var Args concept
val numbers = arrayOf(1, 2, 3) // we haven't given any particular type to this array
val names = arrayOf("1", 2, "3") // we haven't given any particular type to this array

// when you explicitly mention any type then you cannot add anything other than that type
val namesArr = arrayOf<String>("1", "2", "3")

// Constructing Arrays using Array in Kotlin and initializing it
var arr = Array(5, { i -> i })

val numArray = intArrayOf()

// initializing an array of nulls
val nullArray = arrayOfNulls<Int>(5)

fun main() {
    println(arr[2])
    println(arr.get(2))
}