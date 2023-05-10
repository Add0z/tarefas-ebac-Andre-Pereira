package br.com.andrepereira.singleton;

public class SingletonPropriedadeSync {
    private static SingletonPropriedadeSync singleton;
    private String value;


    private SingletonPropriedadeSync(String value) {

        this.value = value;

    }

    public static synchronized SingletonPropriedadeSync getInstance(String value) {
        if (singleton == null) {
            singleton = new SingletonPropriedadeSync(value);
        }
        return singleton;
    }

    public String getValue() {
        return value;
    }
}
