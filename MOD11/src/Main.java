import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    String nome;

    public static void main(String[] args) {
        List Lnome = new ArrayList<>();
//        String nome = "Carol, Bernardo, Andre, David, Elena";
        System.out.println("PARTE 1");
        Scanner leia = new Scanner(System.in);
        System.out.print("Quais os nomes?(nome,) ");
        String nome = leia.nextLine();
        String[] nomeSep = nome.split(",\\s");
        for (int x = 0; x < nomeSep.length; x++) {
            Lnome.add(nomeSep[x]);
        }
        System.out.print("Lista por ordem original: ");
        for (int x = 0; x < Lnome.size(); x++) {
            System.out.print(Lnome.get(x));
            if (x < (Lnome.size() - 1)) {
                System.out.print(", ");

            } else System.out.print(".\n");
        }

        Collections.sort(Lnome);
        System.out.print("Lista por ordem alfabetica: ");
        for (int y = 0; y < Lnome.size(); y++) {
            System.out.print(Lnome.get(y));
            if (y < (Lnome.size() - 1)) {
                System.out.print(", ");

            } else System.out.print(".\n");
        }

        System.out.println();
//---------------------------------------------------------------------------------//
        System.out.println("PARTE 2");
        List Mnome = new ArrayList<>();
        List Fnome = new ArrayList<>();
        List Inome = new ArrayList<>();

//        String nome2 = "Carol -f, Bernardo -m, Andre -m, David -m, Elena -f";
        Scanner leia2 = new Scanner(System.in);
        System.out.print("Quais os nomes?(nome -m/f,) ");
        String nome2 = leia2.nextLine();
        String[] nome2Sep = nome2.split(",\\s");
        for (int x = 0; x < nome2Sep.length; x++) {
            Inome.add(nome2Sep[x]);
        }
        for (int x = 0; x < Inome.size(); x++) {
            String temp = Inome.get(x).toString();
            String[] temp2 = temp.split("-");


            if (temp2[1].equals("m")) {
                Mnome.add(temp2[0]);
            } else if (temp2[1].equals("f")){
                Fnome.add(temp2[0]);
                
            }

        }
        Collections.sort(Fnome);
        Collections.sort(Mnome);
        Collections.sort(Inome);
        System.out.println("Lista original: " + Inome);
        System.out.println("Nomes femininos: " + Fnome);
        System.out.println("Nomes masculinos: " + Mnome);

    }


}
