package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    Observable.range(0,10)//(1)
            .startWith(-1)//(2)
            .subscribe({
                println("Received $it")
            })

    listOf("C","C++","Java","Kotlin","Scala","Groovy")//(3)
            .toObservable()
            .startWith("Programming Languages")//(4)
            .subscribe({
                println("Received $it")
            })
}