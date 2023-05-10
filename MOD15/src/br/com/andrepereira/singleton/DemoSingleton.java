package br.com.andrepereira.singleton;

public class DemoSingleton {

    public static void main(String args[]){
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
//mesmo nome de objeto pois são sempre o mesmo obj
        System.out.println(singleton);
        System.out.println(singleton1);

    }

}
