package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(0,10)//(1)
            .filter{it>15}//(2)
            .defaultIfEmpty(15)//(3)
            .subscribe({
                println("Received $it")
            })
}