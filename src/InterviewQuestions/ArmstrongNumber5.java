package InterviewQuestions;

public class ArmstrongNumber5 {


    public static boolean  armStrongNumber(int number){
        int num = number;
        int armNum = 0;
        while (num>0){
            int lastdigit = num %10;
            armNum = armNum + (lastdigit * lastdigit * lastdigit);
            num = num/10;
        }

        return armNum == number;
    }

    public static void main(String[] args){

        System.out.println(armStrongNumber(153));

    }
}
