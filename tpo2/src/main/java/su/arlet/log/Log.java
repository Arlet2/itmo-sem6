package su.arlet.log;

import su.arlet.Calculatable;

public class Log implements Calculatable {
    private final Ln ln = new Ln();

    private int base;

    public Log setBase(int base) {
        this.base = base;
        return this;
    }

    public double calculate(int base, double x, double eps) {
        return ln.calculate(x, eps) / ln.calculate(base, eps);
    }

    public double calculate(double x, double eps) {
        return ln.calculate(x, eps) / ln.calculate(base, eps);
    }
}