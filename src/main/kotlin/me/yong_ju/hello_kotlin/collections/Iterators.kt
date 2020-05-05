package me.yong_ju.hello_kotlin.collections

fun main() {
    run {
        val numbers = listOf("one", "two", "three", "four")
        val numbersIterator = numbers.iterator()
        while (numbersIterator.hasNext()) {
            println(numbersIterator.next())
        }
    }

    // Another way to go through an `Iterator` collection is the well-known `for`
    // loop. When using `for` on a collection, you obtain the iterator
    // implicitly.
    run {
        val numbers = listOf("one", "two", "three", "four")
        for (item in numbers) {
            println(item)
        }
    }

    // Finally, there is a useful `forEach()` function that lets you
    // automatically iterate a collection and execute the given code for each
    // element.
    run {
        val numbers = listOf("one", "two", "three", "four")
        numbers.forEach {
            println(it)
        }
    }

    //
    // List iterators

    run {
        val numbers = listOf("one", "two", "three", "four")
        val listIterator = numbers.listIterator()
        while (listIterator.hasNext()) listIterator.next()
        println("Iterating backwards:")
        while (listIterator.hasPrevious()) {
            print("Index: ${listIterator.previousIndex()}")
            print(", value: ${listIterator.previous()}")
        }
    }

    //
    // Mutable iterators

    run {
        val numbers = mutableListOf("one", "two", "three", "four")
        val mutableIterator = numbers.iterator()

        mutableIterator.next()
        mutableIterator.remove()
        println("After removal: $numbers")
    }

    // In addition to removing elements, the `MutableListIterator` can also
    // insert and replace elements while iterating the list.
    run {
        val numbers = mutableListOf("one", "four", "four")
        val mutableIterator = numbers.listIterator()

        mutableIterator.next()
        mutableIterator.add("two")
        mutableIterator.next()
        mutableIterator.set("three")
        println(numbers)
    }
}
