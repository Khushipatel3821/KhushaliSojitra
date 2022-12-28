import java.lang.Integer.parseInt
fun main() {
    var marks = arrayOf(1,4,"hint",23.45, 32434.8768)
    for (i in marks)
    {
        println(i)
    }

    // intarray
    var v = IntArray(8)
    var num=0
    for(i in 0..7)
    {
        println("Enter value")
        num= readLine()!!.toInt()
        v[i] = num

    }
    println("Array Element :")
    for(i in 0 .. 7)
    {
        print( " "+v[i])
    }

}