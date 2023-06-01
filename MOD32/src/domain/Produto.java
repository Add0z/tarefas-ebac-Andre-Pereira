package domain;

import org.hibernate.annotations.Check;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO_APOSTILA")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 5, nullable = false, unique = true)
    private String codigo;

    @Column(name = "DESCRICAO", length = 100, nullable = true)
    private String descricao;


    @Column(name = "Digital_Fisica", length = 50, nullable = false)
    @Check(constraints = "Digital_Fisica = 'Digital' or Digital_Fisica = 'Fisica'")
    private String digitalFisica;

    @ManyToOne
    @JoinColumn(name = "id_curso_fk",
            foreignKey = @ForeignKey(name = "fk_curso_produto_apostila"),
            referencedColumnName = "id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_matricula_fk",
            foreignKey = @ForeignKey(name = "fk_matricula_produto_apostila"),
            referencedColumnName = "id", nullable = false)
    private Matricula matricula;


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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getDigitalFisica() {
        return digitalFisica;
    }

    public void setDigitalFisica(String digitalFisica) {
        this.digitalFisica = digitalFisica;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}
