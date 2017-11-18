package com.infinite.kotlinplayground.utility

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.ConnectivityManager
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * Utility classes for Android
 */

const val DEBUG = 1
const val ERROR = 2

fun String.log(tag: String = "Utils", mode: Int = DEBUG) {
    when (mode) {
        DEBUG -> Log.d(tag, this)
        ERROR -> Log.e(tag, this)
    }
}

@SuppressLint("MissingPermission")
fun Context.hasInternet(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return manager.activeNetworkInfo != null && manager.activeNetworkInfo.isConnected
}

fun View.hideKeyboard() {
    val manager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    manager.hideSoftInputFromWindow(windowToken, 0)
}

fun <T> List<T>.satisfiesCondition(condition: (T) -> Boolean): Boolean {
    forEach { if (condition(it)) { return true } }
    return false
}

inline fun SQLiteDatabase.transaction(body: SQLiteDatabase.() -> Unit) {
    beginTransaction()
    try {
        body()
        setTransactionSuccessful()
    } finally {
        endTransaction()
    }
}


inline fun <T> Cursor.mapDataList(dataMapper: Cursor.() -> T): List<T> {
    val list = arrayListOf<T>()

    if (!moveToFirst()) {
        return list
    }

    while (!isAfterLast) {
        list.add(dataMapper(this))
        moveToNext()
    }
    return list
}


inline fun <T> SQLiteDatabase.getDataList(statement: String, dataMapper: Cursor.() -> T): List<T> {
    return rawQuery(statement, null).use { cursor ->
        cursor.mapDataList { dataMapper(cursor) }
    }
}


inline fun <T> Cursor.mapData(action: (Cursor) -> T): T? {
    var value: T? = null
    if (!moveToFirst()) return null
    if (!isAfterLast) {
        value = action(this)
        moveToNext()
    }
    return value
}


inline fun <T> SQLiteDatabase.getData(statement: String, dataMapper: Cursor.() -> T): T? {
    return rawQuery(statement, null).use { cursor ->
        cursor.mapData { dataMapper(it) }
    }
}




