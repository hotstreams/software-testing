package org.ifmo.se.tpo.module

import org.junit.Assert.assertEquals
import org.junit.Test

// remove because this is unit test
class LnTest {
    private val ln = NaturalLogarithmImpl()
    private val e = 0.001

    @Test
    fun `Given real ln When x = 1 Then ln(x) = 0`() {
        assertEquals(0.0, ln(1.0, e), e)
    }

    @Test
    fun `Given real ln When x = E Then ln(x) = 1`() {
        assertEquals(1.0, ln(Math.E, e), e)
    }
}
