//area

fun area(length : Int , breadth: Int , height : Int=10)

{
    println("length is " + length )
    println("breadth is " + breadth)
    println("height is " + height)
}

fun main()
{
    area(breadth = 10,length = 20)
    println(add5(b=6,a=5))
}

//name function = change calling value position by name
fun add5(a:Int,b:Int):Int
{
    var c=a+b
    return c
}
