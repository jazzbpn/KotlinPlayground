package com.infinite.kotlinplayground.screens

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.infinite.kotlinplayground.*
import com.infinite.kotlinplayground.data.AppDatabase
import com.infinite.kotlinplayground.data.cheeses
import com.infinite.kotlinplayground.data.mapCheeseFromCursor
import com.infinite.kotlinplayground.utility.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates


const val GET_ALL_CHEESE = "SELECT * FROM cheese"
const val GET_CHEDDAR_CHEESE = "SELECT * FROM cheese WHERE name LIKE '%cheddar%'"

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private val database: SQLiteDatabase by lazy { AppDatabase(this).writableDatabase }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        "onCreate() called".log(tag = "MainActivity")
        setContentView(R.layout.activity_main)

        // hide keyboard if present
        input_name.hideKeyboard()
        initializeData()

        action_show_dialog.setOnClickListener {
            with(AlertDialog.Builder(this)) {
                setTitle("DevFest 2017")
                setMessage("Hello from the Kotlin talk =)")
                setIcon(R.drawable.ic_launcher_foreground)
            }.show()
        }

        // query for list of cheese
        val cheeseList = database.getDataList(GET_ALL_CHEESE, { mapCheeseFromCursor(this) })
        // query for a specific cheese
        val cheddarCheese = database.getData(GET_CHEDDAR_CHEESE, { mapCheeseFromCursor(this) })

        // sort list alphabetically
        val cheesesStartingWithC = cheeseList
                .sortedBy { it.name }
                .takeWhile { it.name.startsWith("C") }
                .take(10)
        // check if has cheddar cheese
        val hasCheddarCheese = cheesesStartingWithC.satisfiesCondition { it == cheddarCheese }
        if(hasCheddarCheese) {
            // initialize recycler view for cheeses
            cheese_list.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                addItemDecoration(TODO("Add your custom ItemDecoration"))
                itemAnimator = TODO("Add your custom ItemAnimator")
                adapter = TODO("Add your adapter for cheeses")
            }
        }
    }


    @Suppress("UNUSED_EXPRESSION")
    private fun initializeData() {

        if (!this.hasInternet()) {
            // load from cheeses folder
            database.transaction {
                cheeses.forEach { cheese ->
                    "INSERT INTO cheese (name) VALUES ('$cheese')"
                }
            }
            return
        }

        // else load from internet
    }

}
