package lab1.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AtanTest {
    static final double tolerance = 0.01d;

    @Test
    public void testExtremes() {
        assertEquals(Atan.atan(Double.NEGATIVE_INFINITY), Math.atan(Double.NEGATIVE_INFINITY), tolerance);
        assertEquals(Atan.atan(Double.POSITIVE_INFINITY), Math.atan(Double.POSITIVE_INFINITY), tolerance);
        assertEquals(Atan.atan(Double.NaN), Double.NaN);
        assertEquals(Atan.atan(0.0d), Math.atan(0.0d), tolerance);
    }

    @Test
    public void testValues() {
        for (double x = -10.0d; x <= 10.0d; x += 1.0d) {
            assertEquals(Atan.atan(x), Math.atan(x), tolerance);
        }
    }

    @Test
    public void testValuesParity() {
        for (double x = -10.0d; x <= 10.0d; x += 1.0d) {
            assertEquals(Atan.atan(-x), -Atan.atan(x), tolerance);
        }
    }
}
