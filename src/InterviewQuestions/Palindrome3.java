package InterviewQuestions;

public class Palindrome3 {

    public static boolean checkForPalindrome(String s){
        if(s.isEmpty() || s == null){
            return false;
        }
        int n = s.length();
        for(int i=0;i<n/2;i++){
            System.out.print(s.charAt(i));
            System.out.print(s.charAt(n-i-1));
            System.out.println();
            if(s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args){
        System.out.println(checkForPalindrome("neveroddoreven"));
    }
}
