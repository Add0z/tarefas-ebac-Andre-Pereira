import java.util.ArrayList;
import java.util.List;

public class ListaDeCarros {
    public static <T> void main(String[] args) {
        List<T> listaDeCarros = new ArrayList<>();

//Casting the Class on the Generics <T>
//        Problem:
//        ListaDeCarros sub-class
        listaDeCarros.add((T) Lancer.class);
        listaDeCarros.add((T) Skyline.class);
        listaDeCarros.add((T) RX7.class);
        listaDeCarros.add((T) S2000.class);
//        Outside class
        listaDeCarros.add((T) Camaro.class);
        listaDeCarros.add((T) Viper.class);
        listaDeCarros.add((T) Charger.class);
//        Out ListaDeCarros class
        listaDeCarros.add((T) Supra.class);

        listaDeCarros.add((T) "ANDRE DA SILVEIRA PEREIRA");
//        listaDeCarros.add(12131415);
//        listaDeCarros.add((T) 10L);


        imprimir(listaDeCarros);

//Type setting the List to Class<Generic>
//        Problem: Only adds Class
        List<Class<?>> listaDeCarrosMODO2 = new ArrayList<>();
        //        ListaDeCarros sub-class
        listaDeCarrosMODO2.add(Lancer.class);
        listaDeCarrosMODO2.add(Skyline.class);
        listaDeCarrosMODO2.add(RX7.class);
        listaDeCarrosMODO2.add(S2000.class);
        //        Outside class
        listaDeCarrosMODO2.add(Camaro.class);
        listaDeCarrosMODO2.add(Viper.class);
        listaDeCarrosMODO2.add(Charger.class);
        //        Out ListaDeCarros class
        listaDeCarrosMODO2.add(Supra.class);
//        listaDeCarrosMODO2.add("ANDRE DA SILVEIRA PEREIRA");
//        listaDeCarros.add(12131415);
//        listaDeCarros.add((T) 10L);


        for (Class<?> carro : listaDeCarrosMODO2) {
            System.out.println(carro.getSimpleName());

        }
        System.out.println("----------------------------------");


    }
    public static <T> void imprimir(List<T> listaDeCarros) {
        for(T st : listaDeCarros) {
            System.out.println(st);
        }
        System.out.println("----------------------------------");

    }
    static class Lancer {
        //    Lancer
    }

    static class Skyline {
        //Skyline
    }

    static class RX7 {
        //RX7
    }

    static class S2000 {
        //S2000
    }
}

class Supra {
    //Supra
}


