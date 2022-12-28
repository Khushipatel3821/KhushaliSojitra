//single inheritance  and multilevel inheritance
open class Inheritance
{ // level 1

    fun a()
    {
        println("A accessed")
    }
}
open class  B:Inheritance()
{ // level 2
    fun  b()
    {
        println("B accessed")
    }
}
class C: B()
{ // level 3
    fun c()
    {
        println("C accessed")
    }
}
fun main() {

    var c = C()
    c.a()
    c.b()
    c.c()
}
