package com.rivuchk.packtpub.reactivekotlin.chapter08

import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import io.reactivex.subscribers.TestSubscriber
import org.junit.Test
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestRxKotlin {

    @Test
    fun `check emissions count` () {
        val emissionsCount = AtomicInteger()
        Observable.range(1,10)
                .subscribeOn(Schedulers.computation())
                .blockingSubscribe {
                    _ -> emissionsCount.incrementAndGet()
                }

        assertEquals(10,emissionsCount.get())
    }

    @Test
    fun `test with blockingFirst`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
                .sorted()

        val firstItem = observable.blockingFirst()
        assertEquals(1,firstItem)
    }

    @Test
    fun `test Single with blockingGet`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
                .sorted()

        val firstElement:Single<Int> = observable.first(0)

        val firstItem = firstElement.blockingGet()
        assertEquals(1,firstItem)
    }

    @Test
    fun `test Maybe with blockingGet`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
                .sorted()

        val firstElement:Maybe<Int> = observable.firstElement()

        val firstItem = firstElement.blockingGet()
        assertEquals(1,firstItem)
    }

    @Test
    fun `test with blockingLast`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
                .sorted()

        val firstItem = observable.blockingLast()
        assertEquals(10,firstItem)
    }


    @Test
    fun `test with blockingIterable`() {
        val list = listOf(2,10,5,6,9,8,7,1,4,3)

        val observable = list.toObservable()
                .sorted()

        val iterable = observable.blockingIterable()
        assertEquals(list.sorted(),iterable.toList())
    }

    @Test
    fun `test with blockingForEach`() {
        val list = listOf(2,10,5,6,9,8,7,1,4,3,12,20,15,16,19,18,17,11,14,13)

        val observable = list.toObservable()
                .filter { item -> item%2==0 }

        observable.forEach {
            item->
            assertTrue { item%2==0 }
        }
    }

    @Test
    fun `test with TestObserver`() {
        val list = listOf(2,10,5,6,9,8,7,1,4,3,12,20,15,16,19,18,17,11,14,13)

        val observable = list.toObservable().sorted()

        val testObserver = TestObserver<Int>()

        observable.subscribe(testObserver)

        testObserver.assertSubscribed()

        testObserver.awaitTerminalEvent()

        testObserver.assertNoErrors()
        testObserver.assertComplete()
        testObserver.assertValueCount(20)
        testObserver.assertValues(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    }

    @Test
    fun `test with TestSubscriber`() {
        val list = listOf(2,10,5,6,9,8,7,1,4,3,12,20,15,16,19,18,17,11,14,13)

        val flowable = list.toFlowable().sorted()

        val testSubscriber = TestSubscriber<Int>()

        flowable.subscribe(testSubscriber)

        testSubscriber.assertSubscribed()

        testSubscriber.awaitTerminalEvent()

        testSubscriber.assertNoErrors()
        testSubscriber.assertComplete()
        testSubscriber.assertValueCount(20)
        testSubscriber.assertValues(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    }

    @Test
    fun `test by fast forwarding time`() {
        val testScheduler = TestScheduler()

        val observable = Observable.interval(5,TimeUnit.MINUTES,testScheduler)
        val testObserver = TestObserver<Long>()

        observable.subscribe(testObserver)
        testObserver.assertSubscribed()
        testObserver.assertValueCount(0)//(1)

        testScheduler.advanceTimeBy(100,TimeUnit.MINUTES)//(2)
        testObserver.assertValueCount(20)//(3)

        testScheduler.advanceTimeBy(400,TimeUnit.MINUTES)//(4)
        testObserver.assertValueCount(100)//(5)
    }

}