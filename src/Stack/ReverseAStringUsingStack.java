package Stack;

import java.util.Stack;

public class ReverseAStringUsingStack {

    public static String revString(String s){
        Stack stringChars = new Stack<Character>();
        String returnString="";
        for(int i=0;i<s.length();i++){
            Character c = (Character) s.charAt(i);
            stringChars.push(c);
        }
        while (!stringChars.isEmpty()){
            returnString += stringChars.pop();
        }
        return returnString;
    }


    public static void main(String[] args){
        String s = "Charan";
        System.out.println(revString(s));
    }


}
