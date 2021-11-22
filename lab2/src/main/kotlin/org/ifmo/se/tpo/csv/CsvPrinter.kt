package org.ifmo.se.tpo.csv

import java.io.File
import org.ifmo.se.tpo.module.Module

class CsvPrinter(private val module : Module) {
    private val file = File("output.csv")

    fun print(from: Double, to: Double, step: Double, e: Double) {
        file.bufferedWriter().use { out ->
            for (x in from .. to step step) {
                out.write("$x,${module(x, e)}\n")
            }
        }
    }
}

infix fun ClosedRange<Double>.step(step: Double): Iterable<Double> {
    if (step <= 0.0)
        throw IllegalStateException("step must be positive")

    if (!start.isFinite() || !endInclusive.isFinite())
        throw IllegalStateException("range must be finite")

    val sequence = generateSequence(start) { prev ->
        if (prev.isInfinite()) {
            null
        } else {
            val next = prev + step
            if (next > endInclusive) {
                null
            } else {
                next
            }
        }
    }

    return sequence.asIterable()
}
