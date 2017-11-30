package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just(1,2,3,4,5)
            .map { it/(3-it) }
            .onErrorReturn { -1 }//(1)
            .subscribe {
                println("Received $it")
            }
}