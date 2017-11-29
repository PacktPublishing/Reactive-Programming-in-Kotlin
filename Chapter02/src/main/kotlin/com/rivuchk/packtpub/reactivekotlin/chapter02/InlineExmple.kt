package com.rivuchk.packtpub.reactivekotlin.chapter02

/**
 * Created by Rivu Chakraborty on 11-07-2017.
 */

inline fun doSomeStuff(a:Int = 0) = a+(a*a)

fun main(args: Array<String>) {
    for (i in 1..10) {
        println("$i Output ${doSomeStuff(i)}")
    }
}
