package greedzZz.tangent;

import java.math.BigDecimal;
import java.math.MathContext;

public class Tangent {
    public static double tangent(double x) {
        if (x == Math.PI / 2 || x == -Math.PI / 2) return Double.NaN;
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 1; i <= 50; i++) {
            BigDecimal bernoulli = bernoulli(2 * i);
            BigDecimal factorial = factorial(2 * i);
            BigDecimal term = bernoulli.abs();
            term = term.multiply(BigDecimal.valueOf(Math.pow(2, 2 * i)));
            term = term.multiply(BigDecimal.valueOf(Math.pow(2, 2 * i) - 1));
            term = term.multiply(BigDecimal.valueOf(Math.pow(x, 2 * i - 1)));
            term = term.divide(factorial, MathContext.DECIMAL128);
            result = result.add(term);
        }
        return result.doubleValue();
    }

    private static BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }

    private static BigDecimal bernoulli(int n) {
        BigDecimal[] b = new BigDecimal[n + 1];
        b[0] = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            b[i] = BigDecimal.ZERO;
            for (int j = 0; j < i; j++) {
                b[i] = b[i].add(newton(i + 1, j).multiply(b[j]));
            }
            b[i] = b[i].divide(new BigDecimal(i + 1), 40, BigDecimal.ROUND_HALF_UP).negate();
        }
        return b[n];
    }

    private static BigDecimal newton(int n, int k) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= k; i++) {
            result = result.multiply(new BigDecimal(n - i + 1));
            result = result.divide(new BigDecimal(i), 40, BigDecimal.ROUND_HALF_UP);
        }
        return result;
    }
}
