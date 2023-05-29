package Cliente;

import Annotation.TipoChave;

public class Cliente implements Persists {
    @TipoChave("getCpf")
    private Long Cpf;
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

    public Long getCpf() {
        return Cpf;
    }

    public void setCpf(Long cpf) {
        this.Cpf = cpf;
    }

    public Cliente(String nome, Long cpf, Long telefone, String endereco) {
        this.nome = nome;
        this.Cpf = cpf;
        this.tel = telefone;
        this.end = endereco;
    }

    public Cliente(){

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
