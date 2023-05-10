package AbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Customer> clientList = new ArrayList<>();
//        criação do cliente com as escolha de marca e tipo juridico
        Customer customer1 = new Customer("B",true);
        Customer customer2 = new Customer("B",false);
        Customer customer3 = new Customer("A",true);
        Customer customer4 = new Customer("A",false);
        clientList.addAll(List.of(customer1,customer2,customer3,customer4));
//        envido do pedido para fabrica
        for (int x = 0; x < clientList.size(); x++) {
            Factory factory = getWheyFactory(clientList.get(x));
            Whey wheyOne = factory.create(clientList.get(x).getGradeResquest());
            wheyOne.send();
            System.out.println("-------------------------------");
        }
    }

    private static Factory getWheyFactory(Customer customer){
//        Se o cliente é CNPJ então vai para LuxFactory
//        Marcas premium que vendem em quantidades maiores
        if (customer.isCompany()){
            return new LuxFactory();
        } else {
//        Se o cliente é CPF então vai para LuxFactory
//        Marcas low cost que vendem em quantidades menores
            return new CheapFactory();
        }
    }
}
