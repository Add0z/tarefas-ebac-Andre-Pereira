package AbstractFactory;

public class Customer {
//Cliente "escolhe" entre duas marcas de produto,
// duas marcas para CNPJ e duas marcas para CPF
    private String gradeResquest;
//Cliente fala se é CNPJ ou CPF
    private boolean isCompany;

    public Customer(String gradeResquest,  boolean isCompany) {
        this.gradeResquest = gradeResquest;
        this.isCompany = isCompany;
    }

    public boolean isCompany() {
        return isCompany;
    }

    public String getGradeResquest() {
        return gradeResquest;
    }
}
