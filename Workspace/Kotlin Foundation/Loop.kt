import kotlin.math.sign

val list = arrayListOf<Int>()
val map = hashMapOf<Int, Int>()
val set = hashSetOf<Int>()
val array = arrayOfNulls<Int>(5)

// use semi colon ; when writing 2 statements side by side
// thus semi colon basically means end of line and we have to start next statement

fun main() {
    init()
    // forEachTest()
    forLoopTest()
}

fun forLoopTest() {
    for (element in array) {
        print("$element ")
    }
    println()
    for (index in 0..array.size - 1) {
        print("" + array.get(index) + " ")
    }
    println()
    for (index in 0..array.size - 1 step 1) {
        print("" + array.get(index) + " ")
    }
    println()
    for (index in array.indices step 1) {
        print("" + array[index] + " ")
    }
    println()
    for (index in array.indices) {
        // array.size index is exclusive i.e loop runs from 0 to array.size - 1
        print("" + array[index] + " ")
    }
    println()
    for (index in 0 until array.size step 1) {
        print("" + array.get(index) + " ")
    }
    println()
    for (index in array.size - 1 downTo 0 step 1) {
        print("" + array.get(index) + " ")
    }
    println()
    // sample while loop
    var a = 0
    while (a < 10) {
        a += 1
    }
}

fun forEachTest() {
    // Iterating over list
    list.forEach {
        print(it)
    }
    println()
    // Iterating over map
    map.forEach { k, v ->
        println("" + k + " " + v)
    }
    println()
    for ((key, value) in map) {
        println("" + key + " " + value)
    }
    println()
    map.forEach { it ->
        println("" + it.key + " " + it.value)
    }
    println()
    map.forEach {
        println("" + it.key + " " + it.value)
    }
    println()
    // Iterating over set
    set.forEach {
        println(it)
    }
    println()
    // iterating over array
    array.forEach {
        println(it)
    }
    println()
}

fun init() {
    // Iterating over list
    list.add(1)
    list.add(2)
    list.add(3)
    // Iterating over map
    map.put(1, 2)
    map.put(2, 3)
    map.set(3, 4)
    // Iterating over set
    set.add(1)
    set.add(2)
    // iterating over array
    array[0] = 1
    array[1] = 1
    array[3] = 1
    var l = arrayListOf<ArrayList<Int>>()
}