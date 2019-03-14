package javaDesignPatterns.singleton;

public class BillPughSingleton {

    private BillPughSingleton(){}

    private static class ClassHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public BillPughSingleton getInstance(){
        return ClassHelper.INSTANCE;
    }
}
