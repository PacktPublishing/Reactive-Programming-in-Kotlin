package com.rivuchk.packtpub.reactivekotlin.chapter05

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    Observable.range(1,10)
            .reduce { previousAccumulation, newEmission ->  previousAccumulation+newEmission  }
            .subscribeBy { println("accumulation $it") }

    Observable.range(1,5)
            .reduce { previousAccumulation, newEmission ->  previousAccumulation*10+newEmission  }
            .subscribeBy { println("accumulation $it") }
}