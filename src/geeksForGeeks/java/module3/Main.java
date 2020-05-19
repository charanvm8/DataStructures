package geeksForGeeks.java.module3;

public class Main {

    public static void main(String[] args) {

        NestedInner.Inner ne = new NestedInner().new Inner();
        ne.print();
    }
}
