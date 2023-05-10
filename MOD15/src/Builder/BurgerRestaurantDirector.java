package Builder;

public class BurgerRestaurantDirector {
    BurgerBuilder burgerBuilder;

    public BurgerBuilder getBuilder() {
        return burgerBuilder;
    }

    public void setBurgerBuilder(BurgerBuilder burgerBuilder) {
        this.burgerBuilder = burgerBuilder;
    }

    public Burger buildBurger() {
        burgerBuilder.buildBun();
        burgerBuilder.buildMeat();
        burgerBuilder.buildSalad();
        burgerBuilder.buildCheese();
        burgerBuilder.buildSauce();
        return burgerBuilder.build();
    }
}
