import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List media = new ArrayList<>();
        media.add(new Nota("Jose", 6));
        media.add(new Nota("Jose", 6));
        media.add(new Nota("Jose", 6));
        media.add(new Nota("Jose", 6));
        media.add(new Nota("Maria", 10));
        media.add(new Nota("Maria", 10));
        media.add(new Nota("Maria", 10));
        media.add(new Nota("Maria", 10));
        media.add(new Nota("Leticia", 4));
        media.add(new Nota("Leticia", 4));
        media.add(new Nota("Leticia", 4));
        media.add(new Nota("Leticia", 4));



        PrintMedia(media);
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
    }
}
