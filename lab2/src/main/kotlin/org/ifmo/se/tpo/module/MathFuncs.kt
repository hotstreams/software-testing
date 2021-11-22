package org.ifmo.se.tpo.module

import java.math.BigInteger

// TODO: use cache etc :)
fun factorial(n: Int): BigInteger =
    if (n > 0) {
        BigInteger.valueOf(n.toLong()).multiply(factorial(n-1))
    } else {
        BigInteger.ONE
    }
