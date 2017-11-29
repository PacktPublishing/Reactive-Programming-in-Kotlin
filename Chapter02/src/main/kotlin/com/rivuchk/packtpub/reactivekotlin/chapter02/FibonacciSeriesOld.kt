package com.rivuchk.packtpub.reactivekotlin.chapter02

/**
 * Created by rivuc on 14-07-2017.
 */

fun main(args: Array<String>) {
    var a = 0
    var b = 1
    print("$a, ")
    print("$b, ")

    for(i in 2..9) {
        val c = a+b
        print("$c, ")
        a=b
        b=c
    }
}