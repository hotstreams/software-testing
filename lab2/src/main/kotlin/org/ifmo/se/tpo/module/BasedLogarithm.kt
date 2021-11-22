package org.ifmo.se.tpo.module

abstract class BasedLogarithm(val base: Int) : Module

open class BasedLogarithmImpl(base: Int, private val ln: NaturalLogarithm) : BasedLogarithm(base) {
    override fun invoke(x: Double, e: Double): Double = ln(x, e) / ln(base.toDouble(), e)
}

interface Log2 : Module
class Log2Impl(ln: NaturalLogarithm) : Log2, BasedLogarithmImpl(2, ln)

class Log2TableImpl : Log2, TableModule(mapOf(
    0.0 to Double.NEGATIVE_INFINITY,
    1.0 to 0.0,

    3.64786 to 1.86705,
    0.63953 to -0.644916,
    0.2 to -2.32193
))

interface Log10 : Module
class Log10Impl(ln: NaturalLogarithm) : Log10, BasedLogarithmImpl(10, ln)

class Log10TableImpl : Log10, TableModule(mapOf(
    0.0 to Double.NEGATIVE_INFINITY,
    1.0 to 0.0,

    3.64786 to 0.562038,
    0.63953 to -0.194139,
    0.2 to -0.698970
))

interface Log5 : Module
class Log5Impl(ln: NaturalLogarithm) : Log5, BasedLogarithmImpl(5, ln)

class Log5TableImpl : Log5, TableModule(mapOf(
    0.0 to Double.NEGATIVE_INFINITY,
    1.0 to 0.0,

    3.64786 to 0.804095,
    0.63953 to -0.277750,
    0.2 to -1.0,
))
