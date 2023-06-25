package MOD01;

import java.util.ArrayList;
import java.util.List;

public class Fila {
    private List<Integer> fila;

    public Fila() {
        fila = new ArrayList<>();
    }

    public  void enqueuear(int n){
        fila.add(n);
    }

    public  int denqueuear(){
        int deq = fila.get(0);
        fila.remove(0);
        return deq;
    }
    public  int sizear(){
        int size = 0;
        for (Integer z:fila) {
            size++;
        }
        return size;
    }


    public  int rearear(){
        int topIndex = sizear()-1;
        int top = fila.get(topIndex);
        return top;
    }
    public  int frontear(){
        int top = fila.get(0);
        return top;
    }

    public  void isEmptyado(){
        if (sizear() == 0){
            System.out.println("Ta emptyado!");
        } else System.out.println("Não ta emptyado");

//        if (fila.get(0) == null){
//            System.out.println("Ta emptyado!");
//        } else System.out.println("Não ta emptyado");
    }
}
