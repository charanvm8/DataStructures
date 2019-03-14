package InterviewQuestions;

public class Factorial7 {

    public static int factorial(int number){
        if(number == 0){
            return 1;
        }
        return number*factorial(number-1);
    }

    public static int factWithout(int number){
        int fact = 1;
        while(number > 0){
            fact *= number;
            number--;
        }
        return fact;
    }

    public static void main(String[] args){
        int factorial = factWithout(5);
        System.out.println(factorial);
    }
}
