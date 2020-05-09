import java.util.*

// Lists or Collections
// The list doesn't have any function as add, we can only add value while constructing it
val listOfNames = listOf<String>("a", "b")
// MUTABLE
val mutableListOfNames = mutableListOf<String>()
val arrayListOfNames = arrayListOf<String>("default item1", "default item2")

// mapOf is immutable, i.e once assigned cannot be reassigned : IMMUTABLE
val mapOfNames = mapOf<String, Boolean>("random" to false, "another random" to false)

// instead use hashMap for reassignment : MUTABLE
val hashMap = hashMapOf<String, Boolean>()

val javaLL = LinkedList<Int>()
val javaMap = HashMap<String, Int>()

fun main() {
    hashMap.put("random", true)
    println(hashMap)
    println(hashMap.get("random"))
    hashMap.set("work", true)
    println(hashMap["work"])
    arrayListOfNames.add("element1")
    println(arrayListOfNames)
    javaLL.addLast(2)
    println(javaLL)
}