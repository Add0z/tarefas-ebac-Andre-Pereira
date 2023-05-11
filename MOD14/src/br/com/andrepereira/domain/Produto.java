package br.com.andrepereira.domain;

import java.util.Objects;

public class Produto implements Persists {

    private Long code;
    private String name;

    public Produto(String code, String name) {
        this.code = Long.valueOf(code.trim());
        this.name = name;
    }


    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long codeCatch() {
        return code;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return Objects.equals(code, produto.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

