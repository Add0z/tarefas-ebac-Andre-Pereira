package Builder;

public class CheeseBurgerBuilder extends BurgerBuilder {

    @Override
    void buildBun() {
        burger.setBun("WHite Bread");

    }

    @Override
    void buildMeat() {
        burger.setMeat("Beef");

    }

    @Override
    void buildSalad() {
        burger.setSalad("Iceberg");

    }

    @Override
    void buildCheese() {
        burger.setCheese("American Cheese");

    }

    @Override
    void buildSauce() {
        burger.setSauce("Secret Sauce");
    }
}
