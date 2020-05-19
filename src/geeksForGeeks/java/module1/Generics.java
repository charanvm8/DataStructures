package geeksForGeeks.java.module1;

public class Generics<T> {

    T obj;

    public Generics(T obj){
        this.obj = obj;
    }

    public T getValue(){
        return this.obj;
    }

    public static void main(String[] args) {
        Generics<String> s = new Generics<>("Hello");
        System.out.println(s.getValue());
    }
}
