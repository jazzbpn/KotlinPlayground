package com.infinite.kotlinplayground.walkaround

/**
 * Variable declaration
 *
 * You can declare <b>Mutable</b> or <b>Immutable</b> values with Kotlin
 * Note: It is optional for you to declare type
 * Kotlin supports <b>type inference</b>
 */

// Immutable variable declaration with val
val name: String = "Rakeeb"

// Mutable variable declaration with var
var weight: Float = 77f

// compile time constants with const
const val BIRTH_YEAR: Int = 1992

class Life {
    // variables that are initialized later
    lateinit var yearsToLive: String
}

/**
 * Null Explicitness (?)
 *
 * Kotlin has a dedicated type system that mirrors every type
 * the respective Nullable reference
 */

/**
 * Functions
 *
 * Each function Kotlin is a [kotlin.Unit], but type declaration is optional
 * There is presence of single line functions as well
 */

fun printMessage(message: String) {
    println("this is the print message $message")
    println("this is the print message's length ${message.length}")
}


fun loopFor(iterations: Int) {
    // we have ranges!!
    for(i in 0..iterations) {
        printMessage("in loop $i")
    }
}

fun checkIfNumberIsLucky(number: Int): Boolean {
    val isLucky = when (number) {
        0 -> false
        1, 3, 5 -> true
        in 20..39 -> true
        else -> false
    }
    return isLucky
}






