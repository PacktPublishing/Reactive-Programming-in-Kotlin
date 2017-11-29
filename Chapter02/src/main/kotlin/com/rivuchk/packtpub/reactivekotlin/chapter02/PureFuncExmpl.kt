package com.rivuchk.packtpub.reactivekotlin.chapter02

/**
 * Created by Rivu Chakraborty on 7/10/2017.
 */

fun square(n:Int):Int {//(1)
    return n*n
}

fun main(args: Array<String>) {
    println("named pure func square = ${com.rivuchk.packtpub.reactivekotlin.chapter02.square(3)}")
    val qube = {n:Int -> n*n*n}//(2)
    println("lambda pure func qube = ${qube(3)}")
}