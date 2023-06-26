package MOD02;

public class Dinamic_prog_Bottom_Top {
    private static final int maximo = 100;
    private static final long[] listaFac = new long[maximo];

    static {
        listaFac[0] = 1;
        for (int i = 1; i < maximo; i++) {
            listaFac[i] = listaFac[i - 1] * i;
        }
    }

    public static long Fatorial(int n) {
        if (n >= 0 && n < maximo) {
            return listaFac[n];
        } else {
            throw new IllegalArgumentException("O valor de n está fora do limite suportado.");
        }
    }

    public static void main(String[] args) {
        int n = 20;
//        Calcular um fatorial a cima de 20! estoura a quantidade de memoria do tipo Long
        System.out.println("Fatorial de n é: " + Fatorial(n));
    }
}