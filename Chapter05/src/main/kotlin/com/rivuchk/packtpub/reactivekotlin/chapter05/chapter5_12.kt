package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(0,10)//(1)
            .filter{it>15}//(2)
            .switchIfEmpty(Observable.range(11,10))//(3)
            .subscribe({
                println("Received $it")
            })
}