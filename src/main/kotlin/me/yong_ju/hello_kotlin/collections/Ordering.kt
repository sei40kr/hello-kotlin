package me.yong_ju.hello_kotlin.collections

class Version(val major: Int, val minor: Int) : Comparable<Version> {
    override fun compareTo(other: Version): Int {
        if (this.major != other.major) {
            return this.major - other.major
        } else if (this.minor != other.minor) {
            return this.minor - other.minor
        } else return 0
    }
}

fun main(args: Array<String>) {
    run {
        println(Version(1, 2) > Version(1, 3))
        println(Version(2, 0) > Version(1, 5))
    }

    run {
        var lengthComparator = Comparator { str1: String, str2: String -> str1.length - str2.length }
        println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))
    }

    run {
        println(listOf("aaa", "bb", "c").sortedWith(compareBy { it.length }))
    }

    //
    // Natural order

    run {
        val numbers = listOf("one", "two", "three", "four")

        println("Sorted ascending: ${numbers.sorted()}")
        println("Sorted descending: ${numbers.sortedDescending()}")
    }

    //
    // Custom orders

    run {
        val numbers = listOf("one", "two", "three", "four")

        val sortedNumbers = numbers.sortedBy { it.length }
        println("Sorted by length ascending: $sortedNumbers")

        var sortedByLast = numbers.sortedByDescending { it.last() }
        println("Sorted by the last letter descending: $sortedByLast")
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        println("Sorted by length ascending: ${numbers.sortedWith(compareBy { it.length })}")
    }

    //
    // Reverse order

    run {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers.reversed())
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        var reversedNumbers = numbers.asReversed()
        println(reversedNumbers)
    }

    run {
        val numbers = mutableListOf("one", "two", "three", "four")
        var reversedNumbers = numbers.asReversed()
        println(reversedNumbers)
        numbers.add("five")
        println(reversedNumbers)
    }

    //
    // Random order

    run {
        val numbers = mutableListOf("one", "two", "three", "four")
        println(numbers.shuffled())
    }
}
