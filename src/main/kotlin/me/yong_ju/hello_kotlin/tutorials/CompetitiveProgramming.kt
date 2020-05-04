package me.yong_ju.hello_kotlin.tutorials

tailrec fun removeZeroes(x: Int): Int =
    if (x % 10 == 0) removeZeroes(x / 10) else x

fun f(x: Int) = removeZeroes(x + 1)

// Alternatively, we can write an imperative implementation of the function f `f`
// using the traditional while loop and mutable variables that are denoted in
// Kotlin with `var`:
// fun f(x: Int): Int {
//     var cur = x + 1
//     while (cur % 10 == 0) cur /= 10
//     return cur
// }

private fun readLn() = readLine()!! // single line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints

// For example. the Problem B: Long Number problem takes a simple greedy
// algorithm to implement and it can be written using this style without a single
// mutable variable:
fun main() {
    // read input
    var n = readInt()
    var s = readLn()
    var fl = readInts()
    // define local function f
    fun f(c: Char) = '0' + fl[c - '1']
    // greedily find first and last indices
    val i = s.indexOfFirst { c -> f(c) > c }
        .takeIf { it >= 0 } ?: s.length
    val j = s.withIndex().indexOfFirst { (j, c) -> j > i && f(c) < c }
        .takeIf { it >= 0 } ?: s.length
    val ans =
        s.substring(0, i) +
        s.substring(i, j).map { c -> f(c) }.joinToString("") +
        s.substring(j)
    println(ans)
}
