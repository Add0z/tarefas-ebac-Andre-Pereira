package MOD01;

import java.util.ArrayList;
import java.util.List;

public class Pilha {
    private List<Integer> pilha;

    public Pilha() {
        pilha = new ArrayList<>();
    }

    public  void pushar(int n){

        pilha.add(n);

    }

    public  int sizear(){

        int size = 0;
        for (Integer z:pilha) {
            size++;
        }
        return size;
    }

    public  int popar(){

        int topIndex = sizear()-1;
        int top = pilha.get(topIndex);
        pilha.remove(topIndex);
        return top;
    }
    public  int toppear(){

        int topIndex = sizear()-1;
        int top = pilha.get(topIndex);
        return top;}

    public  void isEmptyado(){
        if (sizear() == 0){
            System.out.println("Ta emptyado!");
        } else System.out.println("Não ta emptyado");
    }




}

//
//TODO
//isEmpty
