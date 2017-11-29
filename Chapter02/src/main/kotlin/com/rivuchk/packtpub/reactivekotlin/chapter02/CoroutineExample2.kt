package com.rivuchk.packtpub.reactivekotlin.chapter02

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Created by rivuc on 13-07-2017.
 */

fun main(args: Array<String>) {
    val time = async(CommonPool) { longRunningTsk() }
    println("Print after async ")
    runBlocking { println("printing time ${time.await()}") }
}