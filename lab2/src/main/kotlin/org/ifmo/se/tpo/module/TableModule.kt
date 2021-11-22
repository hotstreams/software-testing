package org.ifmo.se.tpo.module

class NoTableValueException(x: Double) : RuntimeException("No table value for x = $x")

abstract class TableModule(private val table: Map<Double, Double>) : Module {
    override fun invoke(x: Double, e: Double): Double = table.getOrElse(x, { throw NoTableValueException(x) })
}
