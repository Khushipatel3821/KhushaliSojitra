class Constructor(var id : Int, var name : String) // parameter give at class name
{
    //primary constructor
}
class Constructor1
{
// Secondary Constructor // parameter give option for one construtor
    constructor(mark:Int)
    {

    }
    constructor(mark:Int,city:String)
    {

    }
}
fun main()
{
    var con = Constructor(12,"Patel") // primary
    println("Your id is ${con.id}  , your name is ${con.name}")
    var con1 = Constructor1(45) // secondary option 1
    var con2 = Constructor1(223, "Rajkot") // secondary 

}