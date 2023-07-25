package ds.MOD13.DS.MOD3.estrangulado.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class JogoUsuario {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Jogo jogo;

    @OneToOne
    private Usuario usuario;

    public JogoUsuario() {

    }

    public JogoUsuario(Jogo jogo, Usuario usuario) {
        this.jogo = jogo;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
