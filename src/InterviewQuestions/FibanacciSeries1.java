package InterviewQuestions;

public class FibanacciSeries1 {

    public static int fibRecursive(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        return fibRecursive(number-1)+fibRecursive(number-1);
    }

    public static void main(String[] args){
        int fibNum = fibRecursive(13);
        System.out.println(fibNum);
    }
}
