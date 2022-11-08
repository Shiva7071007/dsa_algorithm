import java.lang.System

fun fib(n: Int): Long {
    return if(n < 2) n.toLong()
    else fib(n-1)+ fib(n-2)
}

val start = java.lang.System.currentTimeMillis()
val res = fib(50)
val end = java.lang.System.currentTimeMillis()

println("""
    result: $res 
    time: ${end - start}
""".trimIndent())


