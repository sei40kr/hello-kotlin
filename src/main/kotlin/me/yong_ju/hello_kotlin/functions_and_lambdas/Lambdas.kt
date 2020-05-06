package me.yong_ju.hello_kotlin.functions_and_lambdas

fun main(args: Array<String>) {
    //
    // High-Order Functions

    run {
        fun <T, R> Collection<T>.fold(
            initial: R,
            combine: (acc: R, nextElement: T) -> R
        ): R {
            var accumulator: R = initial
            for (element: T in this) {
                accumulator = combine(accumulator, element)
            }
            return accumulator
        }

        val items = listOf(1, 2, 3, 4, 5)
        // Lambda are code blocks enclosed in curly braces.
        items.fold(0, {
            // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i
            println("result = $result")
            // The last expression in a lambda is considered the return value:
            result
        })

        // Parameter types in a lambda are optional if they can be inferred:
        val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })

        // Function references can also be used for higher-order function
        val product = items.fold(1, Int::times)
    }

    //
    // Returning a value from a lambda expression

    run {
        val ints = emptyList<Int>()

        ints.filter {
            val shouldFilter = it > 0
            shouldFilter
        }

        ints.filter {
            val shouldFilter = it > 0
            return@filter shouldFilter
        }
    }

    //
    // Closures

    run {
        val ints = emptyList<Int>()
        var sum = 0
        ints.filter { it > 0 }.forEach {
            sum += it
        }
        print(sum)
    }
}
