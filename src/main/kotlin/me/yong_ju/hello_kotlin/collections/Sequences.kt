package me.yong_ju.hello_kotlin.collections

fun main(args: Array<String>) {
    //
    // Constructing

    // From elements
    run {
        val numbersSequence = sequenceOf("four", "three", "two", "one")
    }

    // From `Iterable`
    run {
        val numbers = listOf("four", "three", "two", "one")
        val numbersSequence = numbers.asSequence()
    }

    // From function
    run {
        val oddNumbers = generateSequence(1) { it + 2 }
        println(oddNumbers.take(2).toList())
        // error: the sequence is infinite
        // println(oddNumbers.count())
    }

    // To create a finite sequence with generateSequence(), provide a function
    // that returns null after the last element you need.
    run {
        val oddNumbersLessThan10 = generateSequence(1) {
            if (it < 10) it + 2 else null
        }
        println(oddNumbersLessThan10.count())
    }

    // From chunks
    run {
        val oddNumbers = sequence {
            yield(1)
            yieldAll(listOf(3, 5))
            yieldAll(generateSequence(7) { it + 2 })
        }
        println(oddNumbers.take(5).toList())
    }

    //
    // Sequence processing example

    // Iterable
    run {
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
        val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)
        println("Lengths of first 4 words longer than 3 chars.")
        println(lengthsList)
    }

    // Sequence
    run {
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
        val wordsSequence = words.asSequence()

        val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)
        println("Lengths of first 4 words longer than 3 chars.")
        println(lengthsSequence.toList())
    }
}
