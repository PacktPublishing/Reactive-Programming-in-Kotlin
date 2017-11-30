package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.Observable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    createObservable()//(1)
            .debounce(200, TimeUnit.MILLISECONDS)//(2)
            .subscribe {
                println(it)//(3)
            }
}

inline fun createObservable():Observable<String> = Observable.create<String> {
    it.onNext("R")//(4)
    runBlocking { delay(100) }//(5)
    it.onNext("Re")
    it.onNext("Reac")
    runBlocking { delay(130) }
    it.onNext("Reactiv")
    runBlocking { delay(140) }
    it.onNext("Reactive")
    runBlocking { delay(250) }//(6)
    it.onNext("Reactive P")
    runBlocking { delay(130) }
    it.onNext("Reactive Pro")
    runBlocking { delay(100) }
    it.onNext("Reactive Progra")
    runBlocking { delay(100) }
    it.onNext("Reactive Programming")
    runBlocking { delay(300) }
    it.onNext("Reactive Programming in")
    runBlocking { delay(100) }
    it.onNext("Reactive Programming in Ko")
    runBlocking { delay(150) }
    it.onNext("Reactive Programming in Kotlin")
    runBlocking { delay(250) }
    it.onComplete()
}