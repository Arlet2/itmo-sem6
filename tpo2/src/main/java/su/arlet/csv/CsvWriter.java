package su.arlet.csv;

import su.arlet.Calculatable;
import su.arlet.Function;
import su.arlet.log.Ln;
import su.arlet.log.Log;
import su.arlet.trigonometric.*;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private final double eps;

    public CsvWriter(double eps) {
        this.eps = eps;
    }

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();
    private final Tan tan = new Tan();
    private final Cot cot = new Cot();
    private final Sec sec = new Sec();

    private final Ln ln = new Ln();
    private final Log log = new Log();

    private final Function function = new Function();

    public void saveToCsv(String filePath, double x, double limit, double step, int action) {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            writer.write(toCsv(x, limit, step, action));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String toCsv(double x, double limit, double step, int action) {
        StringBuilder result = new StringBuilder();
        Calculatable f = switch (action) {
            case 0 -> function;
            case 1 -> sin;
            case 2 -> cos;
            case 3 -> tan;
            case 4 -> cot;
            case 5 -> sec;
            case 6 -> ln;
            case 7 -> log.setBase(2);
            case 8 -> log.setBase(3);
            default -> throw new UnsupportedOperationException();
        };

        while (x <= limit) {
            var y = f.calculate(x, eps);
            if (!Double.isNaN(y))
                result.append(x).append(", ").append(y).append("\n");
            x += step;
        }

        return result.toString();
    }
}
