package Produto;

import Annotation.TipoChave;
import Cliente.Persists;

import java.math.BigDecimal;

public class Produto implements Persists {

    @TipoChave("getCodigo")
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;

    public Produto(String codigo, String nome, String descricao, BigDecimal valor){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto(){

    }

    public String getCodigo(){

        return codigo;
    }

    public String getNome(){
        return nome;
    }
    public String getDescricao(){

        return descricao;
    }

    public BigDecimal getValor(){

        return valor;

    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao Produto='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {

        this.valor = valor;
    }
}
