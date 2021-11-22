package org.ifmo.se.tpo.module

import kotlin.math.pow

interface FunctionSystem : Module

class FunctionSystemImpl(
    private val cot: Cotangent,
    private val cos: Cosinus,
    private val sin: Sinus,
    private val tan: Tangent,
    private val sec: Secant,
    private val log5: Log5,
    private val log10: Log10,
    private val ln: NaturalLogarithm,
    private val log2: Log2
) : FunctionSystem {
    override fun invoke(x: Double, e: Double): Double =
        if (x <= 0.0) {
            (((cos(x, e) + cot(x, e)) * cos(x, e) + sec(x, e)) * (cos(x, e).pow(3))) + (((sec(x, e) - cos(x, e)) + sin(x, e)) - tan(x, e))
        } else {
            (((((log10(x, e) / log10(x, e)) + ln(x, e)).pow(2)) + (log10(x, e) - log2(x, e))) * (((log10(x, e) - log5(x, e)) - log10(x, e)) + log10(x, e)))
        }
}
