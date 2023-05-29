package Venda;

import Annotation.TipoChave;
import Cliente.Persists;
import Cliente.Cliente;
import Produto.Produto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class Venda implements Persists {

    public enum Status{
        INICIADA, CONCLUIDA, CANCELADA
    }

    @TipoChave("getCodigo")
    private String codigo;
    private Cliente cliente;
    private Set<ProdutoQuantidade> produtos;
    private BigDecimal valorTotal;
    private Instant dataVenda;
    private Status status;

    public Venda(){
        produtos = new HashSet<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ProdutoQuantidade> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto, Integer quantidade) {
        validarStatus();
        Optional<ProdutoQuantidade> op =
                produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
        if (op.isPresent()) {
            ProdutoQuantidade produtpQtd = op.get();
            produtpQtd.adicionar(quantidade);
        } else {
            ProdutoQuantidade prod = new ProdutoQuantidade();
            prod.setProduto(produto);
            prod.adicionar(quantidade);
            produtos.add(prod);
        }
        recalcularValorTotalVenda();
    }

    private void validarStatus(){
        if (this.status == Status.CONCLUIDA){
            throw new UnsupportedOperationException("IMPOSSIVEL ALTERAR VENDA CONCLUIDA");

        }
    }

    public void removerProduto(Produto produto, Integer quantidade){
        validarStatus();
        Optional<ProdutoQuantidade> op = produtos.stream().filter(filter -> filter.getProduto().getCodigo().equals(produto.getCodigo())).findAny();
        if (op.isPresent()) {
            ProdutoQuantidade prodQtd = op.get();
            if (prodQtd.getQuantidade() > quantidade){
                prodQtd.remover(quantidade);
                recalcularValorTotalVenda();
            }else {
                produtos.remove(op.get());
                recalcularValorTotalVenda();
            }
        }
    }

    public void removerTodosProdutos(){
        validarStatus();
        produtos.clear();
        valorTotal = BigDecimal.ZERO;
    }

    public Integer getQuantidadeTotalProdutos(){
        int result = produtos.stream().reduce(0, (partialCountResult, prod) -> partialCountResult + prod.getQuantidade(), Integer::sum);
        return result;
    }

    private void recalcularValorTotalVenda(){
        validarStatus();
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (ProdutoQuantidade prod : this.produtos){
            valorTotal = valorTotal.add(prod.getValorTotal());
        }
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Instant getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Instant dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
