public class Nota {

    private int nota;
    private String nome;

    private int prova;

    public Nota(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;

    };
    public Nota(){};


    public int getNota() {

        return nota;
    }

    public void setNota(int nota) {

        this.nota = nota;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

}