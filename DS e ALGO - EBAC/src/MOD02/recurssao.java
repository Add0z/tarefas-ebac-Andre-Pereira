package MOD02;

public class recurssao {

    public static long Fatorial(long n){
        if (n <= 1){
            return n;
        }
        return Fatorial(n - 1) * n;
    }

    public static void main(String[] args) {
        Integer n = 20;

        System.out.println("Fatorial de n é: "+ Fatorial(n));
    }
}
