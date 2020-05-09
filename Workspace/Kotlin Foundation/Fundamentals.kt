fun main() {
    // val for value, it cannot be reassigned
    val a: String = "Hello World"
    val d: Int = 10
    println(a)
    println(sumOneLine(1, 2))
    // var for variable, can be reassigned but type of variable can be reassigned only once
    var f = "Yo"
    println(f)
    // lateinit concept
    usingLateinit()
    // null safety, !! operator(to use some variable as not null) and elvis operator
    nullSatefyandElvis()
    // string concatenation
    stringConcat()
}

fun sumOneLine(a: Int, b: Int): Int = a + b

// var f: String -> cannot do this due to no initialization
// val f: String -> same reason
// Do late initialization as we can assign some value later to it as well
lateinit var f: String
fun usingLateinit(): Unit {
    f = "late init var"
    println(f)
    // to prevent from crashing or getting error, do this i.e check if the lateinit variable was initialized or not
    if (::f.isInitialized) {
        println(f?.length)
    }
}

// null safe ? tells this variable can hold null

var g: String? = null
fun nullSatefyandElvis() {
    // val len: Int = g?.length!!
    // !! means irrespective of type of variable, we are using it to not null
    // val len = g?.length!! -> this also causes crash due to null pointer exception
    // this was wrong because we cannot be sure if len is not null but still
    // we are using it as not null by adding !! at the end
    var len = g?.length
    println(len)
    // using elvis operator to set default value in case if left value is null
    len = g?.length ?: 0
    println(len)
}

// lateinit must have a type declaration
lateinit var language: String
fun stringConcat() {
    val name = "Tanishq"
    println("My name is ${name.capitalize()} and it's length is ${name.length}")
    val a = true
    val x = if (a) 1 else 2
    println(x)
    val arr = arrayOf(1, 2, 3)
    println(arr)
    Foo.bar()
    language = "French"
    // type declaration becomes mandatory if you’re not initializing the variable(var) or val at the time of declaration
    var anotherString: String
    anotherString = "happy"
    anotherString = "still happy"

    val an: String
    an = "first assignment"
    // an = "not possible" -> Val cannot be reassigned
}

class Foo {
    companion object {
        fun bar(): String = "Kotlin"
    }
}



