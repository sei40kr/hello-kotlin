package me.yong_ju.hello_kotlin.collections

fun main(args: Array<String>) {
    //
    // Retrieving by position
    run {
        val numbers = linkedSetOf("one", "two", "three", "four", "five")
        println(numbers.elementAt(3))

        val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
        println(numbersSortedSet.elementAt(0))
    }

    run {
        val numbers = listOf("one", "two", "three", "four", "five")
        println(numbers.first())
        println(numbers.last())
    }

    run {
        val numbers = listOf("one", "two", "three", "four", "five")
        println(numbers.elementAtOrNull(5))
        println(numbers.elementAtOrElse(5) { index -> "The value for index $index is undefined" })
    }

    //
    // Retrieving by condition

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.first { it.length > 3 })
        println(numbers.last { it.startsWith("f") })
    }

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.firstOrNull() { it.length > 6 })
    }

    run {
        val numbers = listOf(1, 2, 3, 4)
        println(numbers.find { it % 2 == 0 })
        println(numbers.findLast { it % 2 == 0 })
    }

    //
    // Random element

    run {
        val numbers = listOf(1, 2, 3, 4)
        println(numbers.random())
    }

    //
    // Check existence

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.contains("four"))
        println("zero" in numbers)

        println(numbers.containsAll(listOf("four", "two")))
        println(numbers.containsAll(listOf("one", "zero")))
    }

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.isEmpty())
        println(numbers.isNotEmpty())

        val empty = emptyList<String>()
        println(empty.isEmpty())
        println(empty.isNotEmpty())
    }
}
