fun main(args: Array<String>) {

    println("Enter Your Choice: ")
    var choice = readLine()!!.toInt()

    when(choice)
    {
        1->
            println("Android")
        2->
        println("Java")
        3->
            println("Python")
        4->
            println("Flutter")
    }
}