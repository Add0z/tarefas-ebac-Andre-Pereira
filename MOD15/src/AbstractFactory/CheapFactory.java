package AbstractFactory;

public class CheapFactory extends Factory{
    @Override
    Whey retrieveWhey(String requestedGrade) {
        switch (requestedGrade) {
            case "A":
                return new Growth(4,"85%","Milkshake", "Growth");
            case "B":
                return new Darkness(2,"97%","Plain", "Darkness");
            default:
                System.out.println("Product Unavailable");
                return null;
        }
    }
}
