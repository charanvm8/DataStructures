package InterviewQuestions;

public class ReverseAString8 {

    public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static String revString(String s){
        if(s.isEmpty() || s == null){
            return s;
        }
        String rev = "";

        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }


    public static void main(String[] args){
        String s = "Charan";
        System.out.println(revString(s));
    }
}
