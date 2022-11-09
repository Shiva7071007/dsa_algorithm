import java.lang.System

/**
 * time: O(n)
 * space: O(n)
 */
val mem = LongArray(500) {-1}
mem[0] = 0
mem[1] = 1

fun fib(n: Int): Long {
    if(mem[n] == -1L) mem[n] = fib(n-1)+ fib(n-2)
    return mem[n]
}

val start = java.lang.System.currentTimeMillis()
val res = fib(150)
val end = java.lang.System.currentTimeMillis()

println("""
    result: $res 
    time: ${end - start}
""".trimIndent())