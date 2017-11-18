package com.infinite.kotlinplayground.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by rakeeb on 11/18/17.
 */
const val DATABASE_NAME = "database.db"
const val DATABASE_VERSION = 1
class AppDatabase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Write Table logic here")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Write Table update logic here")
    }
}