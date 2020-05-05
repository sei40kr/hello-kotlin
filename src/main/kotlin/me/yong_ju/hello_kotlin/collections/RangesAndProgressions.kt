package me.yong_ju.hello_kotlin.collections

fun main() {
    run {
        val i = 1

        if (i in 1..4) { // equivalent of 1 <= i && i <= 4
            print(i)
        }
    }

    run {
        // To iterate numbers reverse order, use the `downTo` function instead of
        // `..`.
        for (i in 4 downTo 1) print(i)
    }

    run {
        // It is also possible to iterate over numbers with an arbitrary step
        // (not necessarily 1). This is done via the `step` function.
        for (i in 1..8 step 2) print(i)
        println()
        for (i in 8 downTo 1 step 2) print(i)
    }

    run {
        // To iterate a number range which does not include its end element, use
        // the `until` function:
        for (i in 1 until 10) {
            print(i)
        }
    }

    //
    // Range

    // To create a range for your class, call the `rangeTo()` function on the
    // range start value and provide the end value as an argument.
    // `rangeTo()` is often called in its operator form `..`,
    // val versionRange = Version(1, 11)..Version(1, 30)
    // println(Version(0, 9) in versionRange)
    // println(Version(1, 20) in versionRange)

    //
    // Progression

    run {
        for (i in 1..10) print(i)
    }
    run {
        for (i in 1..8 step 2) print(i)
    }

    // The `last` element is not always the same as the specified end value.
    run {
        for (i in 1..9 step 3) print(i) // the last element is 7
    }

    // To create a progression for iteerating in reverse order, use `downTo`
    // instead of `..` when defining the range for it.
    run {
        for (i in 4 downTo 1) print(i)
    }

    // Progressions implement `Iterable<N>`, where `N` is `Int`, `Long`, or
    // `Char` respectively, so you can use them in various collection functions
    // like `map`, `filter`, and other.
    println((1..10).filter { it % 2 == 0 })
}
