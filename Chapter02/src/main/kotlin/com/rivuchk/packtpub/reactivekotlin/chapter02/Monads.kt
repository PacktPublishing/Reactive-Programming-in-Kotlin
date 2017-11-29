package com.rivuchk.packtpub.reactivekotlin.chapter02

import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

/**
 * Created by rivuc on 15-07-2017.
 */

fun main(args: Array<String>) {
    val maybeValue: Maybe<Int> = Maybe.just(14)//1
    maybeValue.subscribeBy(//2
            onComplete = {println("Completed Empty")},
            onError = {println("Error $it")},
            onSuccess = { println("Completed with value $it")}
    )
    val maybeEmpty:Maybe<Int> = Maybe.empty()//3
    maybeEmpty.subscribeBy(
            onComplete = {println("Completed Empty")},//4
            onError = {println("Error $it")},//5
            onSuccess = { println("Completed with value $it")}//6
    )
}