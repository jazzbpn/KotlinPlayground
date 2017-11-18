package com.infinite.kotlinplayground.walkaround

/**
 * Kotlin distinguishes between <b>mutable</b> and
 * <b>immutable</b> collections (lists, sets, maps, pairs, etc)
 */

val cannotAddToThisList = listOf(1, 2, 3, 4)
val canAddToThisList = mutableListOf(1, 2, 3, 4)
val keyValueMaps = mapOf("Android" to "Kotlin",
        "iOS" to "Kotlin",
        "Web" to "Kotlin",
        "World Domination!" to "Kotlin")

fun playWithCollections() {

    // functional operators
}