package me.yong_ju.hello_kotlin.collections

fun main() {
    run {
        val numbers = listOf("one", "two", "three", "four", "five")

        println(numbers.groupBy { it.first().toUpperCase() })
        println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))
    }

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.groupingBy { it.first() }.eachCount())
    }
}
