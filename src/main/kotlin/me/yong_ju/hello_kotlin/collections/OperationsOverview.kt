package me.yong_ju.hello_kotlin.collections

fun main(args: Array<String>) {
    run {
        val numbers = listOf("one", "two", "three", "four")
        // nothing happends with `numbers`
        numbers.filter { it.length > 3 }
        // result is stored in `longerThan3`
        val longerThan3 = numbers.filter { it.length> 3 }
        println("numbers longer than 3 chars are $longerThan3")
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        val filterResults = mutableListOf<String>() // destination object
        numbers.filterTo(filterResults) { it.length > 3 }
        numbers.filterIndexedTo(filterResults) { index, _ -> index == 0 }
        println(filterResults) // contains results of both operations

        // filter numbers right into a new hash set, thus eliminating duplicates
        // in the result
        val result = numbers.mapTo(HashSet()) { it.length }
        println("distinct item lengths are $result")
    }

    //
    // Write operations

    val numbers = mutableListOf("one", "two", "three", "four")
    val sortedNumbers = numbers.sorted()
    println(numbers == sortedNumbers) // false
    numbers.sort()
    println(numbers == sortedNumbers) // true
}
