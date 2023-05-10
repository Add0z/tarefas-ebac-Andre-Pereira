package Builder;

public class VeganBurgerBuilder extends BurgerBuilder{

    @Override
    void buildBun() {
        burger.setBun("WHite Bread");

    }

    @Override
    void buildMeat() {
        burger.setMeat("Vegan Beef");

    }

    @Override
    void buildSalad() {
        burger.setSalad("Vegan Iceberg");

    }

    @Override
    void buildCheese() {
        burger.setCheese("Vegan American Cheese");

    }

    @Override
    void buildSauce() {
        burger.setSauce("Vegan Secret Sauce");
    }
}
