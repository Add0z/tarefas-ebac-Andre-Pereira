package ds.MOD12.MOD12.mongo.modelo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Jogo")
public class Jogo {

    @Id
    private String id;

    private String nome;
    private String distribuidora;
    private String desenvolvedora;
    private String platforma;

    public Jogo(String nome, String distribuidora, String desenvolvedora, String platforma) {
        this.nome = nome;
        this.distribuidora = distribuidora;
        this.desenvolvedora = desenvolvedora;
        this.platforma = platforma;
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

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public String getPlatforma() {
        return platforma;
    }

    public void setPlatforma(String platforma) {
        this.platforma = platforma;
    }
}
