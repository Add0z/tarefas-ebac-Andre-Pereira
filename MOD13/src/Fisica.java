public class Fisica extends Pessoa {

    private Long cpf;
    private String sobrenome;
    private Long renda;
    private Integer elementosFamilia;
    private String religião;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Long getRenda() {
        return renda;
    }

    public void setRenda(Long renda) {
        this.renda = renda;
    }

    public Integer getElementosFamilia() {
        return elementosFamilia;
    }

    public void setElementosFamilia(Integer elementosFamilia) {
        this.elementosFamilia = elementosFamilia;
    }

    public String getReligião() {
        return religião;
    }

    public void setReligião(String religião) {
        this.religião = religião;
    }
}
