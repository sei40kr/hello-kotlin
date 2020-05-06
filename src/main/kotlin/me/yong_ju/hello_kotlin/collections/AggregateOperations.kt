package me.yong_ju.hello_kotlin.collections

fun main(args: Array<String>) {
    run {
        val numbers = listOf(6, 42, 10, 4)

        println("Count: ${numbers.count()}")
        println("Max: ${numbers.max()}")
        println("Min: ${numbers.min()}")
        println("Average: ${numbers.average()}")
        println("Sum: ${numbers.sum()}")
    }

    run {
        val numbers = listOf(5, 42, 10, 4)
        val min3Remainder = numbers.minBy { it % 3 }
        println(min3Remainder)

        val strings = listOf("one", "two", "three", "four")
        val longestString = strings.maxWith(compareBy { it.length })
        println(longestString)
    }

    run {
        val numbers = listOf(5, 42, 10, 4)
        println(numbers.sumBy { it * 2 })
        println(numbers.sumByDouble { it.toDouble() / 2 })
    }

    //
    // Fold and reduce

    run {
        val numbers = listOf(5, 2, 10, 4)

        val sum = numbers.reduce { sum, element -> sum + element }
        println(sum)
        val sumDoubled = numbers.fold(0) { sum, element -> sum + element * 2 }
        println(sumDoubled)

        // incorrect: the first element isn't doubled in the result
        // val sumDoubledReduce = numbers.reduce { sum, element -> sum + element * 2 }
        // println(sumDoubledReduce)
    }

    run {
        val numbers = listOf(5, 2, 10, 4)
        val sumDoubledRight = numbers.foldRight(0) { element, sum -> sum + element * 2 }
        println(sumDoubledRight)
    }

    run {
        val numbers = listOf(5, 2, 10, 4)
        val sumEven = numbers.foldIndexed(0) { idx, sum, element -> if (idx % 2 == 0) sum + element else sum }
        println(sumEven)

        val sumEvenRight = numbers.foldRightIndexed(0) { idx, element, sum -> if (idx % 2 == 0) sum + element else sum }
        println(sumEvenRight)
    }
}
