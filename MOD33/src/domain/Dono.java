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
@Table(name = "TB_DONO")
public class Dono {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dono_seq")
    @SequenceGenerator(name = "dono_seq", sequenceName = "seq_dono", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "Codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "Nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "Pais", length = 50, nullable = false, unique = true)
    private String pais;

    @Column(name = "Telefone", nullable = false, unique = true)
    private Long telefone;

    @OneToOne(mappedBy = "dono")
    private Carro carro;





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

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }


}