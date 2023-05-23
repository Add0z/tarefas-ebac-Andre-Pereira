package Domain;

import Annotation.TipoChave;

import java.util.Objects;

public class Cliente implements Persists {
    @TipoChave("getCpf")
    private String Cpf;
    private String nome;
    private Long tel;
    private String end;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public Cliente(String nome, String cpf, Long telefone, String endereco) {
        this.nome = nome;
        this.Cpf = cpf;
        this.tel = telefone;
        this.end = endereco;
    }

    @Override
    public String toString() {
        return "Cliente " +
                "Cpf= " + Cpf +
                ", nome= " + nome + '\'' +
                ", tel= " + tel +
                ", end= " + end + '\'';
    }

}
