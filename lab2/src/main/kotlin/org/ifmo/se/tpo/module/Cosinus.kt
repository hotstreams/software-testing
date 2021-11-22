package org.ifmo.se.tpo.module

import kotlin.math.pow
import kotlin.math.sqrt

interface Cosinus : Module

class CosinusImpl(private val sin: Sinus) : Cosinus {
    override fun invoke(x: Double, e: Double): Double = sqrt(1.0 - sin(x, e).pow(2))
}

class CosinusTableImpl : Cosinus, TableModule(mapOf(
    0.0         to 1.0,
    Math.PI/6   to sqrt(3.0) / 2,
    Math.PI/4   to sqrt(2.0) / 2,
    Math.PI/3   to 0.5,
    Math.PI/2   to 0.0,
    2*Math.PI/3 to -0.5,
    3*Math.PI/4 to -sqrt(2.0) / 2,
    5*Math.PI/6 to -sqrt(3.0) / 2,
    Math.PI     to -1.0,
    -Math.PI    to -1.0,
    -Math.PI/2  to 0.0,
    2*Math.PI   to 1.0,

    -5.0569 to 0.338,
    -0.3998944 to 0.9214717,
    -6.683079707179586 to 0.9214717,
    -3.652745307179586 to -0.872181,
    -9.935930614359172 to -0.872181,
    -2.63532 to -0.874558,
    -11.339754 to 0.337425,
    -8.918505307179586 to -0.874558,
))
