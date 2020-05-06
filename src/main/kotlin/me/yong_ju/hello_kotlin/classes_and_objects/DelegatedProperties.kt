package me.yong_ju.hello_kotlin.classes_and_objects

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    run {
        class Delegate {
            operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
                return "$thisRef, thank you for delegating '${property.name}' to me"
            }

            operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
                println("$value has been assigned to '${property.name}' in $thisRef.")
            }
        }

        class Example {
            var p: String by Delegate()
        }

        var e = Example()
        println(e.p)

        e.p = "NEW"
    }

    //
    // Standard Delegates

    // Lazy
    run {
        val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }

        println(lazyValue)
        println(lazyValue)
    }

    // Observable
    run {
        class User {
            var name: String by Delegates.observable("<no name>") {
                _, old, new ->
                    println("$old -> $new")
            }
        }

        val user = User()
        user.name = "first"
        user.name = "second"
    }

    //
    // Storing Properties in a Map

    run {
        // This works also for var's properties if you use a `MutableMap`
        // instead of read-only `Map`.
        class User(val map: Map<String, Any>) {
            val name: String by map
            val age: Int by map
        }

        val user = User(mapOf(
            "name" to "John Doe",
            "age" to 25
        ))

        println(user.name)
        println(user.age)
    }

    //
    // Local Delegated Properties (since 1.1)

    run {
        class Foo {
            fun isValid() = true

            fun doSomething() {}
        }

        fun example(computeFoo: () -> Foo) {
            val memoizedFoo by lazy(computeFoo)

            if (memoizedFoo.isValid()) {
                memoizedFoo.doSomething()
            }
        }
    }
}
