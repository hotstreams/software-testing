package org.ifmo.se.tpo.module

import kotlin.math.abs
import kotlin.math.pow

interface NaturalLogarithm : Module

class NaturalLogarithmImpl : NaturalLogarithm, BaseModule({ x, n ->
    if (abs(x) > 1) {
        1.0 / (n * x.pow(n))
    } else {
        if (n % 2 == 0) {
            -x.pow(n) / n
        } else {
            x.pow(n) / n
        }
    }
}) {
    private fun adjustX(x: Double) =
        if (abs(x) <= 1.0) x - 1.0
        else x / (x - 1)

    override fun invoke(x: Double, e: Double): Double {
        return super.invoke(adjustX(x), e)
    }
}

class NaturalLogarithmTableImpl : NaturalLogarithm, TableModule(mapOf(
    0.0 to Double.NEGATIVE_INFINITY,
    1.0 to 1.0,

    3.64786 to 1.29414,
    0.63953 to -0.447022,
    0.2 to -1.60944,
))
