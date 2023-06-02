package domain;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aces_seq")
    @SequenceGenerator(name = "aces_seq", sequenceName = "seq_aces", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "Codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "Nome", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name = "Descrição", length = 50, nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false )
    private BigDecimal valor;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "carros_acess", joinColumns = {@JoinColumn ( name = "id_acess_fk")}, inverseJoinColumns = {@JoinColumn ( name = "id_carro_fk" )})
    private List<Carro> carros;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
