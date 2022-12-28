open class HybridInheritance
{
    fun hybrid()
    {
        println("Hybrid class")
    }
}
open class P: HybridInheritance()
{
    fun p()
    {
        println("P class")
    }
}
class Q : HybridInheritance()
{
    fun q()
    {
        println("Q class")
    }
}
class R : P()
{
    fun r()
    {
        println("R class")
    }
}
fun main()
{
    var hybrid1 = Q()
    var hybrid2 = R()

    hybrid1.q()
    hybrid1.hybrid()
    hybrid2.r()
    hybrid2.p()
    hybrid2.hybrid()


}