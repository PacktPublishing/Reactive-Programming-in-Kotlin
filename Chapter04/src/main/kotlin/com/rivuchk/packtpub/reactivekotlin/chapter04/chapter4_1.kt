package com.rivuchk.packtpub.reactivekotlin.chapter04

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    val observable = Observable.just(1,2,3,4,5,6,7,8,9)//(1)
    val subject = BehaviorSubject.create<Int>()
    subject.observeOn(Schedulers.computation())//(2)
            .subscribe({//(3)
                println("Subs 1 Received $it")
                runBlocking { delay(200) }//(4)
            })

    subject.observeOn(Schedulers.computation())//(5)
            .subscribe({//(6)
                println("Subs 2 Received $it")
            })
    observable.subscribe(subject)//(7)
    runBlocking { delay(2000) }//(8)
}
