package me.yong_ju.hello_kotlin.collections

fun main(args: Array<String>) {
    val numbers = listOf("one", "two", "three", "four")
    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    println(plusList)
    println(minusList)
}
