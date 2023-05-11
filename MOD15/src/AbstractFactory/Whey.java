package AbstractFactory;

public abstract class Whey {

    private int quantity;
    private String purity;
    private String flavor;
    private String marca;

    public Whey(int quantity,String purity,String flavor, String marca){
        this.quantity = quantity;
        this.purity = purity;
        this.flavor = flavor;
        this.marca = marca;
    }

    public void cookUp() {
        System.out.println("[{"+getClass().getSimpleName().toUpperCase()+"}]"+"The " + purity + " purity has been achieved, and " + quantity + "kilos is ready to be flavored");
    }
    public void mix() {
        System.out.println("["+marca.toUpperCase()+"]"+"The " + flavor + " flavor is ready to be add");
    }
    public void boxUp() {
        System.out.println("["+marca.toUpperCase()+"]"+"The " + quantity +  "kilos " + flavor + " flavor is boxed up" );
    }
    public void send() {
        System.out.println("["+marca.toUpperCase()+"]"+"The " + quantity +  "kilos is being sent" );
    }
}
