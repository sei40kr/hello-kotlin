package me.yong_ju.hello_kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    // Bridging blocking and non-blocking worlds
    run {
        GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello, ")
        runBlocking {
            delay(2000L)
        }
    }

    // Waiting for a job
    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("World!")
        }
        println("Hello,")
        job.join()
    }

    // Coroutines ARE light-weight
    runBlocking {
        // Launches 100K coroutines and, after a second, each coroutine prints a dot.
        // Try with threads. What would happen?
        repeat(100_000) {
            launch {
                delay(1000L)
                print(".")
            }
        }
    }
}
