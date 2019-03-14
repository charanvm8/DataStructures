package practicePack;

public interface Drawable {

    void printShape();

    default void msg(){System.out.println("default method");}

}
