package su.arlet.trigonometric;

import su.arlet.Calculatable;

public class Sec implements Calculatable {
    private final Cos cos = new Cos();

    public double calculate(double x, double eps) {
        return (1 / cos.calculate(x, eps));
    }
}