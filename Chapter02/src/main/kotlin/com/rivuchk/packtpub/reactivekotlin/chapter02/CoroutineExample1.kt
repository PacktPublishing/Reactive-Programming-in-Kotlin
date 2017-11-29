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

suspend fun longRunningTsk():Long {//(1)
    val time = measureTimeMillis {//(2)
        println("Please wait")
        delay(2,TimeUnit.SECONDS)//(3)
        println("Delay Over")
    }
    return time
}

fun main(args: Array<String>) {
    runBlocking {//(4)
        val exeTime = longRunningTsk()//(5)
        println("Execution Time is $exeTime")
    }
}