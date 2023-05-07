import java.util.Comparator;

public class Notasort implements Comparator<Nota> {

    @Override
    public int compare(Nota o1, Nota o2) {
        return Integer.compare(o1.getNota(), o2.getNota());
    }
}
