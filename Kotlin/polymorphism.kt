class OverloadinEx
{
    fun add(a:Int,b:Int):Int
    {
        return  a+b
    }

    fun add(a:Int,b:Int,c:Int):Int
    {
        return  a*b+c
    }
}


// overriding
open class Bank8
{
    open fun rate() :Int
    {
        return 0
    }
}
class Sbi :Bank8()
{
    override fun rate() :Int
    {
        return 7
    }
}
class Icici :Bank8()
{
    override fun rate() :Int
    {
        return 8
    }
}
class Axis :Bank8()
{
    override fun rate() :Int
    {
        return 9
    }
}
fun main()
{
    var o1 =OverloadinEx()
    println(o1.add(10,20))
    println(o1.add(10,20,30))

    var b = Bank8()
    b=Sbi()
    println(b.rate())
    b=Icici()
    println(b.rate())
    b=Axis()
    println(b.rate())
}