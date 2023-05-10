package Builder;

public class Demo {
    public static void main(String[] args){
//        BurgerRestaurantDirector gerente = new BurgerRestaurantDirector(new CheeseBurgerBuilder());
        BurgerRestaurantDirector gerente = new BurgerRestaurantDirector();
        gerente.setBurgerBuilder(new CheeseBurgerBuilder());
        Burger burger = gerente.buildBurger();
        burger.print();


        gerente.setBurgerBuilder(new VeganBurgerBuilder());
        Burger burger1 = gerente.buildBurger();
        burger1.print();
    }
}
