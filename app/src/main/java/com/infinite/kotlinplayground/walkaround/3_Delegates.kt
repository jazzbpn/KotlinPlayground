package com.infinite.kotlinplayground.walkaround

import kotlin.properties.Delegates
import kotlin.reflect.KProperty


/**
 * Delegates
 *
 * Closely resembles the Delegation pattern,
 * where we delegate certain logic to other parts of our code
 */
interface Callbacks {
    fun onCallback1(): Boolean
    fun onCallback2()
    fun onCallback3()
    fun onCallback4()
    fun onCallback5()
}

class Impl : Callbacks by Dummy() {
    override fun onCallback1(): Boolean {
        TODO("not implemented")
    }
}

open class Dummy: Callbacks {

    override fun onCallback1(): Boolean {
        TODO("not implemented")
    }

    override fun onCallback2() {
        TODO("not implemented")
    }

    override fun onCallback3() {
        TODO("not implemented")
    }

    override fun onCallback4() {
        TODO("not implemented")
    }

    override fun onCallback5() {
        TODO("not implemented")
    }

}

/**
 * Property delegation
 *
 */

val willKnowValueAfterwards: String by Delegates.notNull()

// Very close to Singleton
val database: String by lazy { "MY DATABASE" }
// if (database == null) {
//      database = "Some Value"
// }
// return database

val tweets: String by Delegates.observable("DevFest KTM 2017, Yeah!") {
    _, old, new ->
    println("$old -> $new")
}

var myCustomDelegation: String by Delegate()

/**
 * Custom delegates - We'll be using operator functions here
 * In this case we're adding functionality on top of setters and getters
 */
class Delegate {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}