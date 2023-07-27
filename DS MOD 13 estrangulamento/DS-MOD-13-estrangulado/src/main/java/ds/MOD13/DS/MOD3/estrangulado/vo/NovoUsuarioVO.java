package ds.MOD13.DS.MOD3.estrangulado.vo;


import java.io.Serializable;

public class NovoUsuarioVO implements Serializable {
    private final String id;
    private final String nome;
    private final String login;
    private final String idade;

    private Integer alturaCm;


    public NovoUsuarioVO(String id, String nome, String login, String idade) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.idade = idade;
    }

    public String getId() {
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
