package InterviewQuestions;

public class PrimeNumber2 {

    public static boolean checkIfPrime(int number){
        if(number == 0 || number == 1){
            return false;
        }
        if(number == 2 || number == 3){
            return true;
        }
        if((number * number -2) % 24 == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){

    }
}
