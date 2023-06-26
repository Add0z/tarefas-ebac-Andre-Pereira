package MOD02;

//Como cada chamada recursiva é independente e envolve uma quantidade constante de trabalho, a complexidade assintótica do algoritmo é O(2^n).
public class fibo {
    private static final int maxx = 100;
    private static final long[]listFibo = new long[maxx];
    public static int FindFibo(int n){

        if (n <= 1){
            return n;
        }
        return FindFibo(n -1 ) + FindFibo(n - 2);

    }

    public static void main(String[] args){
        int n = 4;

        System.out.println(FindFibo(n));
    }
}


//a versão recursiva exponencialmente complexa, pois evita recálculos repetidos dos valores de Fibonacci e reduz a complexidade para uma solução linear O(n).
public class fibo2 {
    private static final int maxx = 100;
    private static final long[]listFibo = new long[maxx];

    public static long DinFac (int n) {
//        Complexidade O(1) - para definir todas as casas da lista com valor -1
        for (int i = 0; i < maxx; i++) {
            listFibo[i] = -1;
        }

        return FindFibo(n);
    }


    public static long FindFibo(int n){
        if (listFibo[n] == -1){
        if (n <= 1){
            listFibo[n] = n;
        } else
            listFibo[n] = FindFibo(n -1 ) + FindFibo(n - 2);
        }
        return listFibo[n];
    }

    public static void main(String[] args){
        int n = 50;

        System.out.println(DinFac(n));
    }
}
