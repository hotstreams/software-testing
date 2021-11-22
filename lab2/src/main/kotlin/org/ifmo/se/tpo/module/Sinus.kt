package org.ifmo.se.tpo.module

import kotlin.math.pow
import kotlin.math.sqrt

interface Sinus : Module

class SinusImpl : Sinus, BaseModule({ x, n ->
    if (n % 2 == 0) {
        -x.pow(2*n - 1) / factorial(2*n - 1).toDouble()
    } else {
        x.pow(2*n - 1) / factorial(2*n - 1).toDouble()
    }
}) {
    private fun adjustX(x: Double) =
        if (x > 2.0 * Math.PI || x < -2.0 * Math.PI) x % (2.0 * Math.PI)
        else x

    override fun invoke(x: Double, e: Double): Double {
        return super.invoke(adjustX(x), e)
    }
}

class SinusTableImpl : Sinus, TableModule(mapOf(
    0.0         to 0.0,
    Math.PI/6   to 0.5,
    Math.PI/4   to sqrt(2.0) / 2,
    Math.PI/3   to sqrt(3.0) / 2,
    Math.PI/2   to 1.0,
    2*Math.PI/3 to sqrt(3.0) / 2,
    3*Math.PI/4 to sqrt(2.0) / 2,
    5*Math.PI/6 to 0.5,
    Math.PI     to 0.0,
    -Math.PI    to 0.0,
    -Math.PI/2  to -1.0,
    2*Math.PI   to 0.0
))
