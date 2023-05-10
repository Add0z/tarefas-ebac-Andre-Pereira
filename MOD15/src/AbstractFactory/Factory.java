package AbstractFactory;

public abstract class Factory {

    public Whey create(String requestedGrade){
        Whey whey = retrieveWhey(requestedGrade);
        whey = prepareWhey(whey);
        return whey;
    }
    private Whey prepareWhey(Whey whey){
        whey.cookUp();
        whey.mix();
        whey.boxUp();
//        whey.send();
        return whey;
    }
    abstract Whey retrieveWhey(String requestedGrade);
}
