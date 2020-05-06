package me.yong_ju.hello_kotlin.collections

fun main() {
    //
    // Slice

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.take(3))
        println(numbers.takeLast(3))
        println(numbers.drop(1))
        println(numbers.drop(1))
    }

    //
    // Take and drop

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.take(3))
        println(numbers.takeLast(3))
        println(numbers.drop(1))
        println(numbers.dropLast(5))
    }

    run {
        val numbers = listOf("one", "two", "three", "four", "five", "six")
        println(numbers.takeWhile { !it.startsWith('f') })
        println(numbers.takeLastWhile { it != "three" })
        println(numbers.dropWhile { it.length == 3 })
        println(numbers.dropLastWhile { it.contains('i') })
    }

    //
    // Chunked

    run {
        val numbers = (0..13).toList()
        println(numbers.chunked(3))
    }

    run {
        val numbers = (0..13).toList()
        println(numbers.chunked(3) { it.sum() })
    }

    //
    // Windowed

    run {
        val numbers = listOf("one", "two", "three", "four", "five")
        println(numbers.windowed(3))
    }

    run {
        val numbers = (1..10).toList()
        println(numbers.windowed(3, step = 2, partialWindows = true))
        println(numbers.windowed(3) { it.sum() })
    }

    run {
        val numbers = listOf("one", "two", "three", "four", "five")
        println(numbers.zipWithNext())
        println(numbers.zipWithNext() { s1, s2 -> s1.length > s2.length })
    }
}
