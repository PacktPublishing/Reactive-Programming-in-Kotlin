package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = listOf(10,9,8,7,6,5,4,3,2,1).toObservable()
    observable.switchMap {
        number->
        Observable.create<String> {//(1)
            it.onNext("The Number $number")//(2)
            it.onNext("number/2 ${number/2}")//(3)
            it.onNext("number%2 ${number%2}")//(4)
            it.onComplete()//(5)
        }
    }.subscribeBy (
            onNext = {
                item-> println("Received $item")
            },
            onComplete = {
                println("Complete")
            }
    )
}

