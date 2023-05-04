// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List media = new ArrayList<>();
        media.add(new Nota("Jose",9));
        Nota maria = new Nota("Maria", 10);
        media.add(maria);
        Nota leticia = new Nota("Leticia", 10);
        media.add(leticia);

        PrintMedia(media);
        }
    public static void PrintMedia(List<Nota> media) {
        float mediaTurma = 0;
        for(int x =0;x<media.size();x++){

            mediaTurma += media.get(x).getNota();
        }
            mediaTurma/=media.size();
            System.out.println("Media da Turma: " + mediaTurma);
    }
}
