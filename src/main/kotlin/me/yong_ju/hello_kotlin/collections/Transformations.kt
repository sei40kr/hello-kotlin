package me.yong_ju.hello_kotlin.collections

fun main(args: Array<String>) {
    //
    // Mapping

    run {
        val numbers = setOf(1, 2, 3)
        println(numbers.map { it * 3 })
        println(numbers.mapIndexed { idx, value -> value * idx })
    }

    // If the transformation produces `null` on certain elements, you can filter
    // out the `null`s from the result collection by calling the `mapNotNull()`
    // function instead of `map()`, or `mapIndexedNotNull()` instead of
    // `mapIndexed()`.
    run {
        val numbers = setOf(1, 2, 3)
        println(numbers.mapNotNull { if (it == 2) null else it * 3 })
        println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0)null else value * idx })
    }

    run {
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        println(numbersMap.mapKeys { it.key.toUpperCase() })
        println(numbersMap.mapValues { it.value + it.key.length })
    }

    //
    // Zipping

    run {
        val colors = listOf("red", "brown", "gray")
        val animals = listOf("fox", "bear", "wolf")
        println(colors zip animals)

        // If the collections have different sizes, the result of the `zip()` is
        // the smaller size; the last eleemnts of the larger collection are not
        // included in the result.
        val twoAnimals = listOf("fox", "bear")
        println(colors.zip(twoAnimals))
    }

    run {
        val colors = listOf("red", "brown", "gray")
        val animals = listOf("fox", "bear", "wolf")

        println(colors.zip(animals) {
                    color, animal -> "The ${animal.capitalize()} is $color"
        })
    }

    run {
        // To unzip a list of pairs, call `unzip()`.
        val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
        println(numberPairs.unzip())
    }

    //
    // Association

    run {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers.associateWith { it.length })
    }

    run {
        val numbers = listOf("one", "two", "three", "four")

        println(numbers.associateBy { it.first().toUpperCase() })
        println(numbers.associateBy(keySelector = { it.first().toUpperCase() }))
    }

    //
    // Flattening

    run {
        val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
        println(numberSets.flatten())
    }

    run {
        class StringContainer(val values: List<String>)

        val containers = listOf(
            StringContainer(listOf("one", "two", "three")),
            StringContainer(listOf("four", "five", "six")),
            StringContainer(listOf("seven", "eight"))
        )
        println(containers.flatMap { it.values })
    }

    //
    // String representation

    run {
        val numbers = listOf("one", "two", "three", "four")

        println(numbers)
        println(numbers.joinToString())

        val listString = StringBuffer("The list of numbers: ")
        numbers.joinTo(listString)
        println(listString)
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))
    }

    run {
        val numbers = (1..100).toList()
        println(numbers.joinToString(limit = 10, truncated = "<...>"))
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers.joinToString() { "Element: ${it.toUpperCase()}" })
    }
}
