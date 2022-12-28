fun main(args: Array<String>) {
//method 1 for represent if else code
    println("Enter num1: ")
    var a = readLine()!!.toInt()
    println("Enter num1: ")
    var b = readLine()!!.toInt()
    if (a>b)
    {
        println("$a is greater than $b")
    }
    else
    {
        println("$b is greater than $a")
    }


    //method 2 for represent if else code

    var c = if (a>b) a else b
    println(c)
}