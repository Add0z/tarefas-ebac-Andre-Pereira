package MOD02;

import java.math.BigInteger;

public class Dinamic_Prog_BigInteger {
    private static final int maximo = 100;
    private static final BigInteger[] listaFac = new BigInteger[maximo];

    public static BigInteger DinFac(int n) {
        for (int i = 0; i < maximo; i++) {
            listaFac[i] = BigInteger.valueOf(-1);
        }

        return Fatorial(BigInteger.valueOf(n));
    }

    public static BigInteger Fatorial(BigInteger n) {
        if (listaFac[n.intValue()].equals(BigInteger.valueOf(-1))) {
            if (n.compareTo(BigInteger.ZERO) <= 0) {
                listaFac[n.intValue()] = BigInteger.ONE;
            } else {
                listaFac[n.intValue()] = Fatorial(n.subtract(BigInteger.ONE)).multiply(n);
            }
        }
        return listaFac[n.intValue()];
    }

    public static void main(String[] args) {
        int n = 25;

        System.out.println("Fatorial de " + n + " é: " + DinFac(n));
    }
}

