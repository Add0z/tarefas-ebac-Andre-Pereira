public class Juridica extends Pessoa {

    private Long cnpj;
    private String nomeFantasia;
    private Double faturamento;
    private Integer numeroFuncionarios;
    private String atividade_economica;

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public String getAtividade_economica() {
        return atividade_economica;
    }

    public void setAtividade_economica(String atividade_economica) {
        this.atividade_economica = atividade_economica;
    }
}
