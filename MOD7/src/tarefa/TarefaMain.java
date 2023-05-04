package tarefa;

public class TarefaMain {
    public static void main(String[] args) {
        Carro lancer = new Carro("Lancer", 2022, 300, 4);

        Carro mustang = new Carro();

        mustang.setNome("Mustang");
        mustang.setAno(2021);
        mustang.setPotencia(400);
        mustang.setPortas(2);

//        lancer.printInfo();
//        mustang.printInfo();
        printInfo(Carro[0]);
        Champs ();

    }
}

