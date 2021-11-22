package org.ifmo.se.tpo

import org.ifmo.se.tpo.csv.CsvPrinter
import org.ifmo.se.tpo.module.*
import java.util.*

fun main() {
    val sin = SinusImpl()
    val ln = NaturalLogarithmImpl()
    val cos = CosinusImpl(sin)
    val sec = SecantImpl(cos)
    val tan = TangentImpl(sin, cos)
    val cot = CotangentImpl(tan)
    val log2 = Log2Impl(ln)
    val log10 = Log10Impl(ln)
    val log5 = Log5Impl(ln)

    val f = FunctionSystemImpl(
        cot = cot, cos = cos, sin = sin, tan = tan, sec = sec, log5 = log5, log10 = log10, ln = ln, log2 = log2
    )

    val scanner = Scanner(System.`in`)
    println("Enter start, end, step, epsilon:")
    CsvPrinter(f).print(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble())
}
