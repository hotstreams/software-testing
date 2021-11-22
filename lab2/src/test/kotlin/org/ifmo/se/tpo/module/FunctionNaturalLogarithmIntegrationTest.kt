package org.ifmo.se.tpo.module

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.ln

class FunctionNaturalLogarithmIntegrationTest {
    private val sin = SinusImpl()
    private val ln = NaturalLogarithmImpl()
    private val cos = CosinusImpl(sin)
    private val sec = SecantImpl(cos)
    private val tan = TangentImpl(sin, cos)
    private val cot = CotangentImpl(tan)
    private val log2 = Log2TableImpl()
    private val log10 = Log10TableImpl()
    private val log5 = Log5TableImpl()

    private val epsilon = 1e-9
    private val diff = 0.01

    private val f = FunctionSystemImpl(
        cot = cot, cos = cos, sin = sin, tan = tan, sec = sec, log5 = log5, log10 = log10, ln = ln, log2 = log2
    )

    @Test
    fun `Given only sinus module When computing function value at F(x) = 0 Then F(x) is correct`() {
        assertEquals(0.5598, f(2 * (Math.PI * 0.0 - 1.31766), epsilon), diff)
        assertEquals(0.5598, f(2 * (Math.PI * -1.0 - 1.31766), epsilon), diff)
        assertEquals(0.006, f(2 * (Math.PI * 0.0 - 0.1999472), epsilon), diff)
        assertEquals(0.006, f(2 * (Math.PI * -1.0 - 0.1999472), epsilon), diff)
        assertEquals(2.499, f(2 * (Math.PI * -1.0 + 1.31522), epsilon), diff)
        assertEquals(2.499, f(2 * (Math.PI * -2.0 + 1.31522), epsilon), diff)
    }

    @Test
    fun `Given only sinus module When x less than 0 and f'x = 0 Then f(x) is correct`() {
        // 2 * (Math.PI * n + 0.613123)
        assertEquals(0.900613, f(-5.0569, epsilon), diff)
        assertEquals(0.900613, f(-11.339754, epsilon), diff)
    }

    @Test
    fun `Given only sinus module When computing function value at x = 0 Then f(x) converges to +inf`() {
        assertEquals(Double.POSITIVE_INFINITY, f(0.0, epsilon), diff)
    }

    @Test
    fun `Given only sinus module When x greater than 0 and f'x = 0 Then f(x) converges to -log(3) div log(2)`() {
        assertEquals(Double.NaN, f(1.0, epsilon), diff)
    }

    @Test
    fun `Given only sinus module When x greater than 0 and Then f(x) is correct`() {
        assertEquals(0.063257, f(0.63953, epsilon), diff)
        assertEquals(0.600366, f(0.2, epsilon), diff)
    }
}
