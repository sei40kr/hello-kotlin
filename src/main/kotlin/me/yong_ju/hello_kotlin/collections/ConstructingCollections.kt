package me.yong_ju.hello_kotlin.collections

fun main() {
    //
    // Constructing from elements

    run {
        val numbersSet = setOf("one", "two", "three", "four")
        val emptySet = mutableSetOf<String>()
    }

    // Note that the `to` notation creates a short-living Pair object, so it's
    // recommended that you use it only if performance isn't critical.
    run {
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    }
    // To avoid excessive memory usage, use alternative ways. For example. you
    // can create a mutable map and populate it using the write operations. The
    // `apply()` // function can help to keep the initialization fluent here.
    // val numbersMap = mutableMapOf<String, String>().apply {
    //     this["one"] = "1"
    //     this["two"] = "2"
    // }

    //
    // Empty colllections

    run {
        val empty = emptyList<String>()
    }
    // There are also functions for creating collections without any elements:
    // - `emptyList()`
    // - `emptySet()`
    // - `emptyMap()`

    //
    // Initializer functions for lists

    // For lists, there is a constructor that takes the list size and the
    // initializer function that defines the element value based on its index.
    run {
        val doubled = List(3, { it * 2 })
        println(doubled)
    }

    //
    // Concrete type constructors

    run {
        val linkedList = LinkedList<String>(listOf("one", "two", "three"))
        val presizedSet = HashSet<Int>(32)
    }

    //
    // Copying

    run {
        val sourceList = mutableListOf(1, 2, 3)
        val copyList = sourceList.toMutableList()
        val readOnlyCopyList = sourceList.toList()
        sourceList.add(4)
        println("Copy size: ${copyList.size}")

        // compilation error
        // readOnlyCopyList.add(4)
        println("Read-only copy size: ${readOnlyCopyList.size}")
    }

    run {
        val sourceList = mutableListOf(1, 2, 3)
        val copySet = sourceList.toMutableSet()
        copySet.add(3)
        copySet.add(4)
        println(copySet)
    }

    run {
        val sourceList = mutableListOf(1, 2, 3)
        val referenceList = sourceList
        referenceList.add(4)
        println("Source size: ${sourceList.size}")
    }

    run {
        val sourceList = mutableListOf(1, 2, 3)
        val referenceList: List<Int> = sourceList
        // compilation error
        // referenceList.add(4)
        sourceList.add(4)
        println(referenceList)
    }

    //
    // Invoking functions on other collections

    run {
        val numbers = listOf("one", "two", "three", "four")
        val longerThan3 = numbers.filter { it.length > 3 }
        println(longerThan3)
    }

    run {
        val numbers = setOf(1, 2, 3)
        println(numbers.map { it * 3 })
        println(numbers.mapIndexed { idx, value -> value * idx })
    }

    run {
        val numbers = listOf("one", "two", "three", "four")
        println(numbers.associateWith { it.length })
    }
}
