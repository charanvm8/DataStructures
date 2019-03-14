package InterviewQuestions;

public class ReverseANumber20 {

    public static int revANumber(int number){
        if(number == 0){
            return 0;
        }

        int revNumber = 0;

        while(number != 0){
            int temp = number%10;
            revNumber = revNumber*10 + temp;
            number = number/10;
        }

        return revNumber;
    }

    public static void main(String[] args){
        System.out.println(revANumber(1285));
    }
}
