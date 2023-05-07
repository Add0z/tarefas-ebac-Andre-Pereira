import java.util.Comparator;

public class Notasort implements Comparator<Nota> {

//    ORDEM ORIGINAL --- primeiro processa o1 -> o2

    @Override
    public int compare(Nota o1, Nota o2) {
        return Integer.compare(o1.getNota(), o2.getNota());
    }
}
//

//    ORDEM INVERTIDA --- primeiro processa o2 -> o1
//    @Override
//    public int compare(Nota o1, Nota o2) {
//        return Integer.compare(o2.getNota(), o1.getNota());
//    }
//}

