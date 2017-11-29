package com.rivuchk.packtpub.reactivekotlin.chapter02

import com.rivuchk.packtpub.reactivekotlin.join
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.buildSequence

/**
 * Created by rivuc on 14-07-2017.
 */

fun main(args: Array<String>) {
    val fibonacciSeries = buildSequence {
        var a = 0
        var b = 1
        yield(a)
        yield(b)

        while (true) {
            val c = a+b
            yield(c)
            a=b
            b=c
        }
    }

    println(fibonacciSeries.take(10) join "," )

}