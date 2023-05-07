public class pessoa implements Comparable<pessoa> {

    private String sexo;
    private String nome;


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "pessoa{" +
                "sexo='" + sexo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int compareTo(pessoa o) {
        return 0;
    }
}