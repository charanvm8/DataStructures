package InterviewQuestions;

public class Palindrome {

    public static boolean palinRec(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        boolean checkIfEqual = s.charAt(0) == s.charAt(s.length()-1);

        return  checkIfEqual? palinRec(s.substring(1,s.length()-2)):false;
    }

    public static void main(String[] args){
        System.out.println(palinRec("aaacaaa"));
    }
}
