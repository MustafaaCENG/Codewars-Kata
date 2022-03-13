package KatasSolution;

import java.math.BigInteger;

public class SumFct {
    public static BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        for(int i = 0; i <= n.intValue(); i++) {
            a = b;
            b = c;
            c = a.add(b);
            sum = sum.add(a);
        }

        return sum.multiply(BigInteger.valueOf(4));
    }
}