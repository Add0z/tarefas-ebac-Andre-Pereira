import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public abstract class Pessoa {

    private String nome;
    private Date nascimento_criação;
    private String enderço;
    private String situação_legal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento_criação() {
        return nascimento_criação;
    }

    public void setNascimento_criação(Date nascimento_criação) {
        this.nascimento_criação = nascimento_criação;
    }

    public String getEnderço() {
        return enderço;
    }

    public void setEnderço(String enderço) {
        this.enderço = enderço;
    }

    public String getSituação_legal() {
        return situação_legal;
    }

    public void setSituação_legal(String situação_legal) {
        this.situação_legal = situação_legal;
    }
}