package su.arlet;

import su.arlet.log.Ln;
import su.arlet.log.Log;
import su.arlet.trigonometric.*;

public class Function implements Calculatable {
    private final Sin sin;
    private final Cos cos;
    private final Tan tan;
    private final Cot cot;
    private final Sec sec;

    private final Ln ln;
    private final Log log;

    public Function() {
        this.sin = new Sin();
        this.cos = new Cos();
        this.tan = new Tan();
        this.cot = new Cot();
        this.sec = new Sec();

        this.ln = new Ln();
        this.log = new Log();
    }

    public Function(Sin sinF, Cos cosF, Tan tanF, Cot cotF, Sec secF,
                    Ln lnF, Log logF) {
        this.sin = sinF;
        this.cos = cosF;
        this.tan = tanF;
        this.cot = cotF;
        this.sec = secF;

        this.ln = lnF;
        this.log = logF;
    }

    public double calculate(double x, double eps) {
        double result;

        if (x <= 0) {
            result = (Math.pow(cos.calculate(x, eps), 2) * tan.calculate(x, eps) + sin.calculate(x, eps))
                    * sec.calculate(x, eps) + Math.pow(Math.pow(cot.calculate(x, eps), 3), 2);

        } else {
            result = ((log.calculate(3, x, eps) / log.calculate(3, x, eps)) /
                    (log.calculate(2, x, eps) * ln.calculate(x, eps)))
                    * log.calculate(2, x, eps) / log.calculate(3, x, eps)
                    - Math.pow(Math.pow(log.calculate(2, x, eps) * ln.calculate(x, eps), 3), 2);
        }

        return result;
    }
}