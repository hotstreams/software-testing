package org.ifmo.se.tpo.module

import kotlin.math.sqrt

interface Secant : Module

class SecantImpl(private val cos: Cosinus) : Secant {
    override fun invoke(x: Double, e: Double): Double = 1.0 / cos(x, e)
}

class SecantTableImpl : Secant, TableModule(mapOf(
    0.0         to 1.0,
    Math.PI/4   to sqrt(2.0),
    Math.PI/2   to Double.POSITIVE_INFINITY,
    3*Math.PI/4 to -sqrt(2.0),
    Math.PI     to -1.0,
    -Math.PI    to -1.0,
    -Math.PI/2  to Double.POSITIVE_INFINITY,
    2*Math.PI   to 1.0,

    -5.0569 to 2.96089,
    -0.3998944 to 1.085221,
    -6.683079707179586 to 1.085221,
    -3.652745307179586 to -1.14655,
    -9.935930614359172 to -1.14655,
    -2.63532 to -1.14343,
    -11.339754 to 2.96362,
    -8.918505307179586 to -1.14343,
))