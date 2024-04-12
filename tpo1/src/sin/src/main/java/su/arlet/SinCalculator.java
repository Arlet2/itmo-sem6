package su.arlet;

public class SinCalculator {

    public double calc(double x, int n) {
        if (x >= 0) {
            while (x > 2 * Math.PI) {
                x -= 2 * Math.PI;
            }
        } else if (x < 0) {
            while (x < 2 * Math.PI) {
                x += 2 * Math.PI;
            }
        }

        double result = 0;

        double pow = x;
        double fact = 1;

        int sign = 1;

        for (int i = 1; i < n; i += 2) {
            fact /= i;

            result += sign * pow * fact;

            sign = -sign;
            pow *= x * x;
            fact /= (i + 1);
        }

        return result;
    }
}