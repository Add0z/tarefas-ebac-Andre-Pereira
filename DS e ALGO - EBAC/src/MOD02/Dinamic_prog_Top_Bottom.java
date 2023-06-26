package MOD02;

public class Dinamic_prog_Top_Bottom {

    private static final int maximo = 100;
    private static final long[] listaFac = new long[maximo];

    public static long DinFac (int n){
//        Complexidade O(1) - para definir todas as casas da lista com valor -1
        for (int i = 0; i < maximo; i++){
            listaFac[i] = -1;
        }

        return Fatorial(n);

    }
    public static long Fatorial(int n){
//        Complexidade O(n) - necessário passar por todos os valors de N até 1


        if (listaFac[n] == -1){
            if (n <= 1){
                listaFac[n] = n;
            } else {

                listaFac[n] = Fatorial(n - 1) * n;
            }
        }
        return listaFac[n];
    }

    public static void main(String[] args) {
        int n = 20;
        //20 é o maximo
//        Calcular um fatorial a cima de 20! estoura a quantidade de memoria do tipo Long

        System.out.println("Fatorial de n é: "+ DinFac(n));
    }
}


