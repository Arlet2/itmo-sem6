package su.arlet;

import su.arlet.csv.CsvWriter;

public class Main {
    public static void main(String[] args) {
        double from = -5.1;
        double to = 1.5;
        double step = 0.12;
        double eps = 0.000001;

        CsvWriter csvWriter = new CsvWriter(eps);

        csvWriter.saveToCsv("src/main/resources/out/function.csv", from, to, step, 0);
        csvWriter.saveToCsv("src/main/resources/out/sin.csv", from, to, step, 1);
        csvWriter.saveToCsv("src/main/resources/out/cos.csv", from, to, step, 2);
        csvWriter.saveToCsv("src/main/resources/out/tan.csv", from, to, step, 3);
        csvWriter.saveToCsv("src/main/resources/out/cot.csv", from, to, step, 4);
        csvWriter.saveToCsv("src/main/resources/out/sec.csv", from, to, step, 5);
        csvWriter.saveToCsv("src/main/resources/out/ln.csv", from, to, step, 6);
        csvWriter.saveToCsv("src/main/resources/out/log2.csv", from, to, step, 7);
        csvWriter.saveToCsv("src/main/resources/out/log3.csv", from, to, step, 8);
    }
}