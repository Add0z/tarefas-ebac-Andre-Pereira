package domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marc_seq")
    @SequenceGenerator(name = "marc_seq", sequenceName = "seq_marc", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "Codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "Nome", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name = "Pais", length = 50, nullable = false, unique = true)
    private String pais;

    @OneToMany(mappedBy = "marca")
    private List<Carro> carrosList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Carro> getCarrosList() {
        return carrosList;
    }

    public void setCarrosList(List<Carro> carrosList) {
        this.carrosList = carrosList;
    }
}
