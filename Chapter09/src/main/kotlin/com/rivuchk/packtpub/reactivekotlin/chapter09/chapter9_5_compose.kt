package com.rivuchk.packtpub.reactivekotlin.chapter09

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.annotations.NonNull
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    Observable.range(1,10)
            .map {
                println("map - ${Thread.currentThread().name} $it")
                it
            }
            .compose(SchedulerManager(Schedulers.computation(),
                    Schedulers.io()))
            .subscribe {
                println("onNext - ${Thread.currentThread().name} $it")
            }

    runBlocking { delay(100) }
}

class SchedulerManager<T>(val subscribeScheduler:Scheduler, val observeScheduler:Scheduler):ObservableTransformer<T,T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler)
    }

}
