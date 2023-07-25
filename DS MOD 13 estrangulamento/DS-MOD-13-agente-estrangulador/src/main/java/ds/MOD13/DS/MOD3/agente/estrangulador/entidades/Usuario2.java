package ds.MOD13.DS.MOD3.agente.estrangulador.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Entity
public class Usuario2 {

    @Id
    private String id;

    private String nome;

    private String login;

    private String idade;

    private String alturaCm;

    public Usuario2() {}

    public Usuario2(String id, String nome, String login, String idade, String alturaCm) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
        this.alturaCm = alturaCm;
    }

    public String getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(String alturaCm) {
        this.alturaCm = alturaCm;
    }

    @PrePersist
    public void criarId(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
