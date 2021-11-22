package org.ifmo.se.tpo.module

import org.junit.Assert.assertEquals
import org.junit.Test

// remove because this is unit test
class SinusTest {
    private val sin = SinusImpl()
    private val e = 0.001

    @Test
    fun `Given real sinus When x = pi*n Then sin(x) = 0`() {
        assertEquals(0.0, sin(0.0, e), e)
        assertEquals(0.0, sin(Math.PI, e), e)
        assertEquals(0.0, sin(-Math.PI, e), e)
        assertEquals(0.0, sin(2*Math.PI, e), e)
        assertEquals(0.0, sin(-2*Math.PI, e), e)
    }

    @Test
    fun `Given real sinus When x = pi*n + half pi Then sin(x) = 1`() {
        assertEquals(1.0, sin(Math.PI / 2.0, e), e)
        assertEquals(-1.0, sin(-Math.PI/2.0, e), e)
    }
}
