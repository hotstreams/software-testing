package org.ifmo.se.tpo.module

import kotlin.math.sqrt

interface Tangent : Module

class TangentImpl(
    private val sin: Sinus,
    private val cos: Cosinus
) : Tangent {
    override fun invoke(x: Double, e: Double): Double = sin(x, e) / cos(x, e)
}

class TangentTableImpl : Tangent, TableModule(mapOf(
    0.0         to 0.0,
    Math.PI/4   to 1.0,
    Math.PI/2   to Double.POSITIVE_INFINITY,
    3*Math.PI/4 to -1.0,
    Math.PI     to 0.0,
    -Math.PI    to 0.0,
    -Math.PI/4  to -1.0,
    -Math.PI/2  to Double.NEGATIVE_INFINITY,
    -3*Math.PI/4 to 1.0,
    2*Math.PI   to 0.0,

    -5.0569 to 2.78691,
    -0.3998944 to -0.421549,
    -6.683079707179586 to -0.421549,
    -3.652745307179586 to -0.560872,
    -9.935930614359172 to -0.560872,
    -2.63532 to 0.554475,
    -11.339754 to 2.78982,
    -8.918505307179586 to 0.554475,
))
