package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.Flowable

fun main(args: Array<String>) {
    val flowable = Flowable.range(1,111)//(1)
    flowable.window(10)
            .subscribe {
                flo->flo.subscribe {
                    print("$it, ")
                }
                println()
            }
}