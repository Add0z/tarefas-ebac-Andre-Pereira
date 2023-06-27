package MOD03;

import java.util.ArrayList;

public class Backtracking {
    private static void calcularSubconjuntos(int[] s, int n, int inicio, int[] subconjuntoAtual, int tamanhoAtual) {
        if (tamanhoAtual == n) {
            imprimir(subconjuntoAtual);
            return;
        }

        for (int i = inicio; i < s.length; i++) {
            subconjuntoAtual[tamanhoAtual] = s[i];
            calcularSubconjuntos(s, n, i + 1, subconjuntoAtual, tamanhoAtual + 1);
            subconjuntoAtual[tamanhoAtual] = 0;
        }
    }

    private static void imprimir(int[] subconjunto) {
        for (int elemento : subconjunto) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 2;
        int[] s = {1, 2, 3};

        int[] subconjuntoAtual = new int[n];
        calcularSubconjuntos(s, n, 0, subconjuntoAtual, 0);
    }
}

