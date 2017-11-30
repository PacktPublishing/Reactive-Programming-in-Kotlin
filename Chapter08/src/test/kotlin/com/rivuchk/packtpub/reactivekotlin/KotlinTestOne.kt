package com.rivuchk.packtpub.reactivekotlin

import io.reactivex.Observable
import org.junit.Test
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals

class TestClass {
    @Test//(1)
    fun `my first test`() {//(2)
        assertEquals(3,2+3, "Actual value is not equal to the expected one.")//(3)
    }

}