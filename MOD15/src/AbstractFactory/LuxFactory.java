package AbstractFactory;

public class LuxFactory extends Factory{
    @Override
    Whey retrieveWhey(String requestedGrade) {
        switch (requestedGrade) {
            case "A":
                return new Probiotica(1000,"80%","Choco", "Probiotica");
            case "B":
                return new MaxTitanium(800,"90%","Cookie", "MaxTitanium");
            default:
                System.out.println("Product Unavailable");
                return null;
        }
    }
}
