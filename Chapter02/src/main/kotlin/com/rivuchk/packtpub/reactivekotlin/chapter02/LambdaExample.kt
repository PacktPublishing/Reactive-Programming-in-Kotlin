package com.rivuchk.packtpub.reactivekotlin.chapter02

import java.util.*

/**
 * Created by Rivu Chakraborty on 7/9/2017.
 */

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y } // (1)
    println("Sum ${sum(12,14)}")// (2)
    val anonymousMult = {x: Int -> (Random().nextInt(15)+1) * x}// (3)
    println("random output ${anonymousMult(2)}")// (4)
}