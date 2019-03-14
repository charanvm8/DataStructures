package Practice;

public class NewPractice {

    enum Colors{
        BLUE,
        PINK,
        YELLOW
    }

    public static void main(String[] args){

        // Java types

        byte b= 1; // 8bit
        short s = 2; // 16 bit
        long l = 10; // 32 bit
        int i = 10; // 64 bit
        double d = 20.0; // 64 bit
        float f = 100.00f; // 32 bit
        char c = 'c'; // 16 bit
        boolean bool =true;

        System.out.println();


        String q= "mareedu";

        switch(q){
            case "mareedu":
                System.out.println("family name");
                break;
            case "charan":
            default:
                System.out.println("not good");
        }

        int[] ints = new int[3];
        System.out.println(ints[2]);
        System.out.println(Colors.BLUE);
    }
}
