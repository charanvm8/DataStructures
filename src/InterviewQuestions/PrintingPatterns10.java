package InterviewQuestions;

public class PrintingPatterns10 {

    public static void drawPyramidPattern() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++)
            {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(k+" ");
            }

            System.out.println();
        }
    }


    public static void main(String[] args){
        System.out.println("Pyramid pattern of star in Java : "); drawPyramidPattern();
    }
}
