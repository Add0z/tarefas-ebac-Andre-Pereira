import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int inttelefone;
        Scanner leia = new Scanner(System.in);
        System.out.println("Hello, qual seu telefone? ");
        inttelefone = leia.nextInt();
        System.out.println("Você digitou: " + inttelefone);
        System.out.println("---Convertendo de integer para Long---");
        Long LONGtelefone = (long) inttelefone;
        System.out.println("integer(primitivo): " + inttelefone);
        System.out.println("Long(wapper): " + LONGtelefone);
        if (inttelefone != LONGtelefone) {
            System.out.println("ALTERAÇÃO DE VALORES");
        }






    }
}
