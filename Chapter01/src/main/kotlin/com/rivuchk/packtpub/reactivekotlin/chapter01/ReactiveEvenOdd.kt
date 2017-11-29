package com.rivuchk.packtpub.reactivekotlin.chapter01

import io.reactivex.Observable
import io.reactivex.functions.Function
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

/**
 * Created by Rivu Chakraborty on 7/3/2017.
 */

fun main(args: Array<String>) {
    var subject: Subject<Int> = PublishSubject.create()

    subject.map({ isEven(it) }).subscribe({println("The number is ${(if (it) "Even" else "Odd")}" )})

    subject.onNext(4)
    subject.onNext(9)
}