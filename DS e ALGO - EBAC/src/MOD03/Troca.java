package MOD03;

import java.util.HashMap;
import java.util.Map;

public class Troca {

    private static void calculadora(int valor,int inicio, int[] moedas, HashMap<Integer, Integer> troco){
        for (int i = inicio; i < moedas.length; i++) {
            int k =  moedas[i];
                int v = valor / moedas[i];
                valor = valor % moedas[i];
                troco.put(k,v);
                calculadora(valor, i + 1, moedas, troco);
        }


    }



    public static void main(String[] args) {
        int valor = 18;
        int[] moedas = {5,2,1};
        HashMap<Integer, Integer> troco = new HashMap<>();

        calculadora(valor,0,moedas,troco);
        troco.forEach((k, v) -> System.out.println("notas de R$" + k  +": "+  v + " unidades"));

    }
}
