fun main() {
    val user: User = User()
    user.mobile

    val account = Account(12345, "tanishq", 1000f)
    account.deposit(100f)
    account.withDraw(150f)
    account.withDraw(50f)
    println(account.amount)
    println("Account no ${account.accNo} by ${account.name}")
}

class User {
    val name: String = ""
    val mobile: Int = 0
    val gender: String = ""
    val email: String = ""
    fun checkEmail(): Boolean {
        return email.isNotEmpty()
    }
}

// Primary Constructor
// Always specify the incoming values in the primary constructor as var or val
// But if we are using init block then we do not have to specify var or val
class Account(accNo: Int, name: String, amount: Float) {
    var accNo: Int
    var name: String
    var amount: Float

    // Init is used to initialize and update/manipulate the constructor's values
    init {
        this.accNo = accNo
        this.name = name.capitalize()
        this.amount = amount + 1000 // Bonus for joining
    }

    /*
      // Secondary constructor
      constructor(accNo: Int) {
          this.accNo = 1
          this.name = "Anonymous"
          this.amount = 0f
      }
  */

    // constructor
    /*
        It is a function with same name as class name
        It is used to construct or initialize the class
        Two types of Constructors :
        1. Primary Constructor - Only 1
        2. Secondary Constructor - Can be Multiple
     */


    // member functions
    // this points to the current receiver

    fun deposit(money: Float) {
        amount += money
        println(amount)
    }

    fun withDraw(money: Float) {
        if (amount < money) {
            println("Not enough funds")
        } else {
            amount -= money
            println(amount)
        }
    }
}