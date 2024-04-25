package su.arlet.trigonometric;

import su.arlet.Calculatable;

public class Cot implements Calculatable {
    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    public double calculate(double x, double eps) {
        return (cos.calculate(x, eps) / sin.calculate(x, eps));
    }
}