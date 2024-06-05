fun main() {
    val immutableVariable: Int = 0
    var mutableVariable: Int = 0

    // Compile error here
    immutableVariable = 1
    mutableVariable = 1

    println(immutableVariable)
    println(mutableVariable)
    println(add(100, 100))
}

fun add(lvalue: Int, rvalue: Int) : Int {
    return lvalue + rvalue
}
