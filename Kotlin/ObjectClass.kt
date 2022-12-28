class ObjectClass {

    var id = 0
    var name = ""
    var city = ""

    fun persondetail()
    {
        println("Your ID is $id")
        println("Your Name is $name")
        println("Your City is $city")
    }
}

fun main(args: Array<String>) {

    var obj = ObjectClass()
   /* obj.id = 111
    obj.name = "Khushi"
    obj.city = "Rajkot"

    obj.persondetail()*/

    //take value from user
    println(" Enter your ID: ")
    var i = readLine()!!.toInt()
    println(" Enter your Name: ")
    var n = readLine().toString()
    println(" Enter your City: ")
    var c = readLine().toString()
    obj.id = i
    obj.name = n
    obj.city = c

    obj.persondetail()

}