package org.ifmo.se.tpo.module

import kotlin.math.abs

open class BaseModule(private val termFunc: (Double, Int) -> Double) : Module {
    override fun invoke(x: Double, e: Double): Double {
        var lastTerm = 0.0
        var result = 0.0
        var n = 0

        do {
            lastTerm = termFunc(x, ++n)
            result += lastTerm
        } while (abs(lastTerm) > e)

        return result
    }
}
