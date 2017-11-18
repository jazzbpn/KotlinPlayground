package com.infinite.kotlinplayground.walkaround

/**
 * Created by rakeeb on 11/17/17.
 */
/**
 * Classes in Kotlin are final by default
 *
 * If you want to make classes extensible use the `open` keyword
 * Constructors can have default values
 * Kotlin supports named parameters
 */


class Animal

class Dog : Animal()
class Cat : Animal()

// constructors and properties
class WithManyProperties(first: Int,
                         second: Int)

fun doSomethingWithManyProperties() {
    val demo = WithManyProperties(1, 2)
    print("initialized demo with first ${demo.first}")
    print("initialized demo with second ${demo.second}")
}

/**
 * Data classes
 */
data class Person(val firstName: String,
                  val lastName: String,
                  var age: Int = 0,
                  var company: String = "Unknown")


fun doSomethingWithPerson() {

    val p1 = Person("Rakeeb", "Rajbhandari")
    val p2 = p1.copy()

    val isEqual = p1 == p2

    println("p1 is $p1")
    println("p2 is $p2")
    println("p1 and p2 are equal $isEqual")

}


/**
 * Extension functions
 */

fun String.getFirstName() = this.split(",")[0]
fun String.getLastName() = this.split(",")[1]

fun String.asPerson() = Person(this.getFirstName(), this.getLastName())


infix fun Person.worksFor(companyName: String) = this.copy(firstName = this.firstName, lastName = this.lastName, company = companyName)

/**
 * Operator functions
 * We can provide implementations for a predefined set of operators in the stdlib
 *
 * for e.g.
 * a++	a.inc()
 * a--	a.dec()
 * ...
 */

operator fun Person.inc() = this.copy(age = this.age++)
