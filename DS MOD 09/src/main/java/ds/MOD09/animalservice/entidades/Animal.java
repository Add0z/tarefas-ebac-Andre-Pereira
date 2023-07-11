package ds.MOD09.animalservice.entidades;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long AnimalId;

    public Long getId() {
        return AnimalId;
    }


    @Column(nullable = false)
    private String nomeProvisoria;
    @Column(nullable = false)
    private String especie;

    @Column(nullable = false)
    private Integer idadeEstimada;
    @Column(nullable = false)
    private String raca;

    @Column(nullable = false)
    private Date dataEntrada;
    @Column
    private Date dataSaida;

    @Column(nullable = false)
    private String condicaoDeChegada;

    @ManyToOne
    @JoinColumn(name = "cuidador_id", nullable = false)
    private Cuidador cuidador;

//    public Integer obterIdCuidador(String nomeCuidador) {
//        Cuidador cuidador = cuidadorRepository.findByNome(nomeCuidador);
//        if (cuidador != null) {
//            return cuidador.getId();
//        }
//        return null; // ou lance uma exceção se necessário
//    }




    @Column
    private Date dataObito;

    @Column(nullable = false)
    private String porte;

    public String getNomeProvisoria() {
        return nomeProvisoria;
    }

    public void setNomeProvisoria(String nomeProvisoria) {
        this.nomeProvisoria = nomeProvisoria;
    }

    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }

    public void setIdadeEstimada(Integer idadeEstimada) {
        this.idadeEstimada = idadeEstimada;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getCondicaoDeChegada() {
        return condicaoDeChegada;
    }

    public void setCondicaoDeChegada(String condicaoDeChegada) {
        this.condicaoDeChegada = condicaoDeChegada;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
