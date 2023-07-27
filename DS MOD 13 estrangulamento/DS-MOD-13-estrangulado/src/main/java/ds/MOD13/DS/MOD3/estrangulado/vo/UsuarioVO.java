package ds.MOD13.DS.MOD3.estrangulado.vo;

import java.io.PrintStream;
import java.io.Serializable;

public class UsuarioVO implements Serializable {

    private final Long id;
    private final String nome;
    private final String login;
    private final String idade;

    private String idNovoUsuario;

    private Integer alturaCm;


    public UsuarioVO(Long id, String nome, String login, String idade) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
    }

    public String getIdNovoUsuario() {
        return idNovoUsuario;
    }

    public void setIdNovoUsuario(String idNovoUsuario) {
        this.idNovoUsuario = idNovoUsuario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getIdade() {
        return idade;
    }

    public Integer getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(Integer alturaCm) {
        this.alturaCm = alturaCm;
    }
}
