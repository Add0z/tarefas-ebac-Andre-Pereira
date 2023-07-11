package ds.MOD09.animalservice.entidades;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Cuidador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long CuidadorId;

    public Long getId() {
        return CuidadorId;
    }


    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private Date dataContratacao;
    @Column
    private Date dataSaida;

    @OneToMany(mappedBy = "cuidador")
    private List<Animal> animais;


    public void setId(Long id) {
        this.CuidadorId = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
}


