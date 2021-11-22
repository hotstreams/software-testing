package org.ifmo.se.tpo.module

interface Module {
    operator fun invoke(x: Double, e: Double): Double
}
