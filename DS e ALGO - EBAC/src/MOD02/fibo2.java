package MOD02;

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