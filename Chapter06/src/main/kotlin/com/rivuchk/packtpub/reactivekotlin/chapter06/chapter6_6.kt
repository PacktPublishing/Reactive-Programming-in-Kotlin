package com.rivuchk.packtpub.reactivekotlin.chapter06

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable1 = listOf("Kotlin", "Scala", "Groovy").toObservable()
    val observable2 = listOf("Python", "Java", "C++", "C").toObservable()

    Observable
            .merge(observable1,observable2)//(1)
            .subscribe {
                println("Received $it")
            }
}