package DomainJpa;

import DaoJpa.ProdutoDaoJpa;
import exception.DAOException;
import exception.TipoChaveNaoEncontradaException;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO_QUANTIDADE")
public class ProdutoQuantidadeJpa {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="prod_qtd_seq")
    @SequenceGenerator(name="prod_qtd_seq", sequenceName="sq_prod_qtd", initialValue = 1, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProdutoJpa produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda_fk",
            foreignKey = @ForeignKey(name = "fk_prod_qtd_venda"),
            referencedColumnName = "id", nullable = false
    )
    private VendaJpa venda;

    public ProdutoQuantidadeJpa() {
        this.quantidade = 0;
        this.valorTotal = BigDecimal.ZERO;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoJpa getProduto() {
        return produto;
    }

    public void setProduto(ProdutoJpa produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public VendaJpa getVenda() {
        return venda;
    }

    public void setVenda(VendaJpa venda) {
        this.venda = venda;
    }
//    public void adicionar(Integer quantidade) {
//        this.quantidade += quantidade;
//        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
//        BigDecimal novoTotal = this.valorTotal.add(novoValor);
//        this.valorTotal = novoTotal;
//    }

    public void adicionar(Integer quantidade, Integer estoque) {
        if( quantidade < estoque){
            this.quantidade += quantidade;
            BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
            BigDecimal novoTotal = this.valorTotal.add(novoValor);
            this.valorTotal = novoTotal;
            this.produto.setEstoque(estoque - quantidade);
            ProdutoDaoJpa produtoDaoJpa = new ProdutoDaoJpa();
            try {
                produtoDaoJpa.alterar(this.produto);
            } catch (TipoChaveNaoEncontradaException e) {
                throw new RuntimeException(e);
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println("IMPOSSÍVEL REALIZAR VENDA - ESTOQUE INSUFICIENTE");
//			throw new UnsupportedOperationException("IMPOSSÍVEL REALIZAR VENDA - ESTOQUE INSUFICIENTE");
        }

    }

    public void remover(Integer quantidade) {
        this.quantidade -= quantidade;
        BigDecimal novoValor = this.produto.getValor().multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = this.valorTotal.subtract(novoValor);
    }

}
