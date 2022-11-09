package probems

/**
 * write a fun "canSum(targetSum, arrayOfNumber): boolean"
 * where fun will return true/false based on whether it's possible or not.
 * number can be used multiple time.
 * all numbers are non-negative
 */


/**
 * m = target sum
 * n = numlist size
 * time: O(n^m)
 * space: O(m)
 */
fun canSum(targetSum: Int, numList: IntArray): Boolean {
    if(targetSum == 0) return true
    val result =  numList.map {
        if(targetSum < it) return false
        canSum(targetSum - it, numList)
    }
    return result.contains(true)
}

fun canSumDynamic(targetSum: Int, numList: IntArray, mem: Array<Boolean?> = Array(1000) {null}): Boolean {
    if(mem[targetSum] == null) {
        if(targetSum == 0) mem[targetSum] = true
        else mem[targetSum] = numList.map {
            if(targetSum < it) return false
            canSumDynamic(targetSum - it, numList, mem)
        }.contains(true)
    }
    return mem[targetSum]!!
}

val target = 39
val numArray = intArrayOf(5,4,3,7)
val numArray1 = intArrayOf(5,4,3,7,8,9,10,11)

val start = System.currentTimeMillis()
val res = canSum(target, numArray)
val end = System.currentTimeMillis()

val startDynamic = System.currentTimeMillis()
val resDynamic = canSumDynamic(target, numArray )
val endDynamic = System.currentTimeMillis()

println("""
    result: $res 
    time: ${end - start}
    
    Dynamic:
    result: $resDynamic
    time: ${endDynamic - startDynamic}
""".trimIndent())