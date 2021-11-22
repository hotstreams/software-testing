package lab1.part1;

public class Atan {
    private static double atan1(double x) {
        double result = 0.0d;
        final int n = 128;

        for (int i = 0; i < n; ++i) {
            result += Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / (2 * i + 1);
        }

        return result;
    }

    public static double atan(double x) {
        if (Math.abs(x) <= 1) {
            return atan1(x);
        } else {
            return Math.signum(x) * Math.PI / 2 - atan1(1 / x);
        }
    }
}
