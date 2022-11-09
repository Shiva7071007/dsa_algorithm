package probems

/**
 * starting from top left of a grid, how many ways we can traverse to bottom right of the grid
 * if only allowed movement are down or right
 */


/**
 * time: O(2^(m+n))
 * space: O(m+n)
 */
fun gridTraveller(m: Int, n: Int): Long {
    return if(m == 0 || n ==0) 0
    else if(m == 1 && n == 1) 1
    else gridTraveller(m-1, n) + gridTraveller(m, n-1)
}

/**
 * time: O(m*n)
 * space: O(m+n)
 */
fun gridTravellerDynamic(m: Int, n: Int, mem: Array<LongArray> = Array(50) { LongArray(50) { -1L } }): Long {
    if(mem[m][n] == -1L) {
        if(m == 0 || n ==0) mem[m][n] = 0L
        else if(m == 1 && n == 1) mem[m][n] = 1L
        else mem[m][n] = gridTravellerDynamic(m-1, n, mem) + gridTravellerDynamic(m, n-1, mem)
    }
    return mem[m][n]
}

val m = 18
val n = 18

val start = System.currentTimeMillis()
val res = gridTraveller(m,n)
val end = System.currentTimeMillis()

val startDynamic = System.currentTimeMillis()
val resDynamic = gridTravellerDynamic(m,n)
val endDynamic = System.currentTimeMillis()

println("""
    result: $res 
    time: ${end - start}
    
    Dynamic:
    result: $resDynamic
    time: ${endDynamic - startDynamic}
""".trimIndent())