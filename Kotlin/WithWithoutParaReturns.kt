//with parameter with return type
fun add(a:Int, b:Int) : Int
{
    return a + b
}

//with parameter without return
fun add1(a: Int,b: Int)
{
    var c = a + b
    println(c)
}

//without parameter with return type
fun add2(): Int
{
    var a = 12
    var b = 13
    var c = a + b

    return c
}

//without parameter without return type
fun add3()
{
    var a = 12
    var b = 13

    var c = a + b

    println(c)
}
fun main() {

    println(add(12,13))
    add1(12,13)
    println(add2())
    add3()



}