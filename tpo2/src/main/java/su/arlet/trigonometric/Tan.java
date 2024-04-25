package su.arlet.trigonometric;

import su.arlet.Calculatable;

public class Tan implements Calculatable {
    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    public double calculate(double x, double eps) {
        return (sin.calculate(x, eps) / cos.calculate(x, eps));
    }

}
