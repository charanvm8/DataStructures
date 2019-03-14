package InterviewQuestions;

public class IntegerPalindrome4 {


    public static int isPalindrome(int number){
        boolean isNegitiveNumber = number<0?true:false;
        if(isNegitiveNumber){
            number = number * -1;
        }

        int revNum = 0;
        int lastDigit = 0;

        while (number > 0){
            lastDigit = number%10;
            revNum = revNum*10+lastDigit;
            number = number/10;
        }

        return isNegitiveNumber?revNum*-1:revNum;


    }

    public static void main(String[] args){

    }
}
