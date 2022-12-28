interface X
{
    fun x1()
    fun x2()
    {
        println("X2 is run")
    }
}
interface Y
{
    fun y1()
    {
        println("Y2 is run")
    }
    fun y2()
}
class Z : X,Y
{
    override fun x1() {
        println("X1 is run")
    }

    override fun y2() {
        println("Y2 is run")
    }
}
fun main()
{
    var h = Z()
    h.x1()
    h.x2()
    h.y1()
    h.y2()
}