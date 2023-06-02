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
import java.math.BigDecimal;
import java.time.Instant;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "TB_CARRO")
public class Carro {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_aces", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "Codigo", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "Nome", length = 50, nullable = false, unique = true)
    private String nome;

    @Column(name = "valor", nullable = false )
    private BigDecimal valor;

    @Column(name = "Ano", nullable = false )
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_marca_carro"),
            referencedColumnName = "id", nullable = false)
    private Marca marca;

    @OneToOne
    @JoinColumn(name = "id_dono_fk",
            foreignKey = @ForeignKey(name = "fk_dono_carro"),
            referencedColumnName = "id")
    private Dono dono;

    @ManyToMany(mappedBy = "carros",cascade = CascadeType.ALL)
    private List<Acessorio> acessorios;

    public Carro() {
        this.acessorios = new ArrayList<Acessorio>();
    }


    public Long getId() {
        return id;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

     public void addAcc(Acessorio acessorio) {
        	this.acessorios.add(acessorio);
        }


   }