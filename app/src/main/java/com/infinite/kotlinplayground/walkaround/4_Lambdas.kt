package com.infinite.kotlinplayground.walkaround

// base score for promotion
val PROMOTION_OFFSET = 100

/**
 * Function that checks each employee evaluation score
 * @param [evaluate] Higher order function where the
 * evaluation score is taken as an input
 *
 * @return status to know if the employee is promotable,
 * compares score against [PROMOTION_OFFSET]
 */
fun isPromotableEmployee(evaluate: () -> Int): Boolean {
    return evaluate() > PROMOTION_OFFSET
}

fun main(args: Array<String>) {
    val employee = Employee("Rakeeb Rajbhandari")
    val hr = Evaluator("Human Resource")
    val manager = Evaluator("Manager")

    if(isPromotableEmployee { hr.scoreEmployee(employee) }
            && isPromotableEmployee{ manager.scoreEmployee(employee) })
        print("$employee, congratulations! you been promoted.")
    else
        print("$employee, sorry better luck next time")
}

class Employee(name: String)
class Evaluator(type: String) {
    fun scoreEmployee(employee: Employee) : Int {
        TODO()
    }
}