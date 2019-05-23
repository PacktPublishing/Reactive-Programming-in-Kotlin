package com.rivuchk.packtpub.reactivekotlin

import org.junit.Test
import kotlin.test.assertEquals

class TestClass {
    @Test//(1)
    fun `my first test`() {//(2)
        assertEquals(3,2+3, "Actual value is not equal to the expected one.")//(3)
    }

}