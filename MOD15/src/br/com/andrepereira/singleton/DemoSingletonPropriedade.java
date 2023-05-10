package br.com.andrepereira.singleton;

public class DemoSingletonPropriedade {

    public static void main(String args[]){
        SingletonPropriedade singleton = SingletonPropriedade.getInstance("Teste");
        SingletonPropriedade singleton1 = SingletonPropriedade.getInstance("1Teste");

            System.out.println(singleton.getValue());

            System.out.println(singleton1.getValue());

    }

}
