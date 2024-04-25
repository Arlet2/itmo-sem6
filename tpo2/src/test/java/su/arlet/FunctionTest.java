package su.arlet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import su.arlet.log.Ln;
import su.arlet.log.Log;
import su.arlet.trigonometric.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FunctionTest {
    static final double eps = 0.000001;
    static final double delta = 10;

    static Sin sinMock;
    static Cos cosMock;
    static Tan tanMock;
    static Cot cotMock;
    static Sec secMock;
    static Ln lnMock;
    static Log logMock;

    static Reader sinIn;
    static Reader cosIn;
    static Reader tanIn;
    static Reader cotIn;
    static Reader secIn;
    static Reader lnIn;
    static Reader log2In;
    static Reader log3In;

    @BeforeAll
    static void init() {
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        tanMock = Mockito.mock(Tan.class);
        cotMock = Mockito.mock(Cot.class);
        secMock = Mockito.mock(Sec.class);

        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);


        try {
            cosIn = new FileReader("src/main/resources/in/cos.csv");
            sinIn = new FileReader("src/main/resources/in/sin.csv");
            tanIn = new FileReader("src/main/resources/in/tan.csv");
            cotIn = new FileReader("src/main/resources/in/cot.csv");
            secIn = new FileReader("src/main/resources/in/sec.csv");
            lnIn = new FileReader("src/main/resources/in/ln.csv");
            log3In = new FileReader("src/main/resources/in/log3.csv");
            log2In = new FileReader("src/main/resources/in/log2.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records) {
                Mockito
                        .when(cosMock.calculate(Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito
                        .when(sinMock.calculate(Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(tanIn);
            for (CSVRecord record : records) {
                Mockito
                        .when(tanMock.calculate(Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cotIn);
            for (CSVRecord record : records) {
                Mockito
                        .when(cotMock.calculate(Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }

            records = CSVFormat.DEFAULT.parse(secIn);
            for (CSVRecord record : records) {
                Mockito
                        .when(secMock.calculate(Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito
                        .when(lnMock.calculate(Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito
                        .when(logMock.calculate(2, Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito
                        .when(logMock.calculate(3, Double.parseDouble(record.get(0)), eps))
                        .thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (IOException ex) {
            System.err.println("IO exception");
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void allMocks(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, cotMock, secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testSin(double value, double expected) {
        Function function = new Function(new Sin(), cosMock, tanMock, cotMock, secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testCos(double value, double expected) {
        Function function = new Function(sinMock, new Cos(), tanMock, cotMock, secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testSinAndCos(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(), tanMock, cotMock, secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testTan(double value, double expected) {
        Function function = new Function(sinMock, cosMock, new Tan(), cotMock, secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testCot(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, new Cot(), secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testTanAndCot(double value, double expected) {
        Function function = new Function(sinMock, cosMock, new Tan(), new Cot(), secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testSec(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, cotMock, new Sec(), lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testCsc(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, cotMock, secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testSecAndCsc(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, cotMock, new Sec(), lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testSinAndTanAndSec(double value, double expected) {
        Function function = new Function(new Sin(), cosMock, new Tan(), cotMock, new Sec(), lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testCosAndCotAndCsc(double value, double expected) {
        Function function = new Function(sinMock, new Cos(), tanMock, new Cot(), secMock, lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testAllTrig(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(), new Tan(), new Cot(), new Sec(), lnMock, logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testLn(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, cotMock, secMock, new Ln(), logMock);
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testLog(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, cotMock, secMock, lnMock, new Log());
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testAllLog(double value, double expected) {
        Function function = new Function(sinMock, cosMock, tanMock, cotMock, secMock, new Ln(), new Log());
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/function.csv")
    void testAll(double value, double expected) {
        Function function = new Function(new Sin(), new Cos(), new Tan(), new Cot(), new Sec(), new Ln(), new Log());
        Assertions.assertEquals(expected, function.calculate(value, eps), delta);
    }
}