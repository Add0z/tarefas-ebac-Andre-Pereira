import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Nota> media = new ArrayList<Nota>();
        Nota Carlos1 = new Nota("Carlos", 6);
        Nota Carlos2 = new Nota("Carlos", 6);
        Nota Carlos3 = new Nota("Carlos", 6);
        Nota Carlos4 = new Nota("Carlos", 6);
        media.add(Carlos1);
        media.add(Carlos2);
        media.add(Carlos3);
        media.add(Carlos4);
        media.add(new Nota("Bernardo", 10));
        media.add(new Nota("Bernardo", 10));
        media.add(new Nota("Bernardo", 10));
        media.add(new Nota("Bernardo", 10));
        media.add(new Nota("André", 4));
        media.add(new Nota("André", 4));
        media.add(new Nota("André", 4));
        media.add(new Nota("André", 4));
        Collections.sort(media);

        PrintMedia(media);

        Notasort notasort = new Notasort();
        Collections.sort(media, notasort);
        System.out.println("LISTA ORDENADA POR NOTA(menor para maior)" + media);
        Collections.sort(media, notasort.reversed());
        System.out.println("LISTA ORDENADA POR NOTA(maior para menor)" + media);


// ESTE METODO REQUER O toSTring() no NOTA
        for (Nota nome: media) {
            System.out.print(" teste-" + nome);

        }



    }

    public static void PrintMedia(List<Nota> media) {
        float mediaTurma = 0;
        for (int x = 0; x < media.size(); x++) {
            float mediaInd = 0;
            int somaInd = 0;
            for (int y = 0; y <= media.size(); y++) {
                if (x == (media.size() - 1)) {
                    mediaInd += media.get(x).getNota();
                    somaInd++;
                    break;
                }
                else if (media.get(x).getNome() != media.get(x + 1).getNome()) {
                    mediaInd += media.get(x).getNota();
                    somaInd++;
//                    x++;
                    break;
                }
                else if (media.get(x).getNome() == media.get(x + 1).getNome()) {
                    mediaInd += media.get(x).getNota();
                    somaInd++;
                    x++;
                }
            }
            mediaTurma += mediaInd;
            mediaInd /= somaInd;
//            System.out.println(media.get(x).getNome() + " " + mediaInd);
            if (mediaInd >= 7){
                System.out.println(media.get(x).getNome() + " " + mediaInd);
                System.out.println(media.get(x).getNome() + ": APROVADO");
            }
            else if (mediaInd < 7 && mediaInd >= 5 ) {
                System.out.println(media.get(x).getNome() + " " + mediaInd);
                System.out.println(media.get(x).getNome() + ": RECUPERAÇÃO");

            }
            else {
                System.out.println(media.get(x).getNome() + " " + mediaInd);
                System.out.println(media.get(x).getNome() + ": REPROVADO");

            }
        }
        mediaTurma /= media.size();
        System.out.println("Media da Turma: " + mediaTurma);

        System.out.println("LISTA ORDENADA POR NOME" + media);


    }
}
