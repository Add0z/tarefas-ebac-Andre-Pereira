// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List media = new ArrayList<>();
        media.add(new Nota("Jose",9));
        media.add(new Nota("Jose",8));
        Nota Jose = new Nota("Jose", 10);
        media.add(Jose);
        Nota Jose2 = new Nota("Jose", 10);
        media.add(Jose);

        PrintMedia(media);
        }
    public static void PrintMedia(List<Nota> media) {
        float mediaJose = 0;
        for(int x =0;x<media.size();x++){

            mediaJose += media.get(x).getNota();
        }
            mediaJose/=media.size();
            System.out.println("Media do Jose: " + mediaJose);
    }
}
