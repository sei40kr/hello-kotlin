package me.yong_ju.hello_kotlin.collections

fun main(args: Array<String>) {
    //
    // Filtering by predicate

    run {
        val numbers = listOf("one", "two", "three", "four")
        val longerThan3 = numbers.filter { it.length > 3 }
        println(longerThan3)

        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10 }
        println(filteredMap)
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        val filteredIdx = numbers.filterIndexed { index, s -> (index != 0 && s.length <5) }
        val filteredNot = numbers.filterNot({ it.length <= 3 })

        println(filteredIdx)
        println(filteredNot)
    }

    run {
        val numbers = listOf(null, 1, "two", 3.0, "four")
        println("All String elements in upper case:")
        numbers.filterIsInstance<String>().forEach {
            println(it.toUpperCase())
        }
    }

    run {
        val numbers = listOf(null, "one", "two", null)
        numbers.filterNotNull().forEach {
            println(it.length)
        }
    }

    //
    // Partitioning

    run {
        val numbers = listOf("one", "two", "three", "four")
        val (match, rest) = numbers.partition { it.length > 3 }
        println(match)
        println(rest)
    }

    //
    // Test predicates

    run {
        val numbers = listOf("one", "two", "three", "four")

        println(numbers.any { it.endsWith("e") })
        println(numbers.none { it.endsWith("a") })
        println(numbers.all { it.endsWith("e") })

        pirntln(emptyList<Int>().all { it > 5 })
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        val empty = emptyList<String>()

        println(numbers.any())
        println(empty.any())

        println(numbers.none())
        println(empty.none())
    }
}
