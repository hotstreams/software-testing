package org.ifmo.se.tpo.module

interface Cotangent : Module

class CotangentImpl(
    private val tan: Tangent
) : Cotangent {
    override fun invoke(x: Double, e: Double): Double = 1.0 / tan(x, e)
}

class CotangentTableImpl : Cotangent, TableModule(mapOf(
    0.0         to Double.POSITIVE_INFINITY,
    Math.PI/4   to 1.0,
    Math.PI/2   to 0.0,
    3*Math.PI/4 to -1.0,
    Math.PI     to 0.0,
    -Math.PI    to Double.NEGATIVE_INFINITY,
    -Math.PI/4  to -1.0,
    -Math.PI/2  to 0.0,
    -3*Math.PI/4 to 1.0,
    2*Math.PI   to 0.0,

    -5.0569 to 0.359,
    -0.3998944 to -2.37220,
    -6.683079707179586 to -2.37220,
    -3.652745307179586 to -1.78293,
    -9.935930614359172 to -1.78293,
    -2.63532 to 1.80351,
    -11.339754 to 0.358447,
    -8.918505307179586 to 1.803506,
))