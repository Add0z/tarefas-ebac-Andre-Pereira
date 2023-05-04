package tarefa;

public class Carro {
    private String nome;
    private int ano;
    private int potencia;
    private int portas;

    public Carro () {};

    public Carro(String nome, int ano, int potenciao, int portas) {
        super();
        this.nome = nome;
        this.ano = ano;
        this.potencia = potenciao;
        this.portas = portas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public void printInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Ano: " + ano);
        System.out.println("Potencia: "+ potencia);
        System.out.println("Portas: "+ portas);
        System.out.println(" ");


    }

}