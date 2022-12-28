fun main(args: Array<String>) {

    println("Enter Your Name :")
    var name = readLine().toString()
    println("Enter Your Password")
    var pass = readLine()!!.toInt()

    println("Your Name is $name")
    println("Your ID is $pass")
}