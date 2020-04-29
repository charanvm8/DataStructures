package Stack.implementation;

import java.util.Stack;

public class StackPalindrome {

    public boolean isPalindrome(String s){
        Stack<Character> charSet = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{'){
                charSet.push(s.charAt(i));
            }
            else{
                char last = charSet.pop();
                //if(s.charAt())
            }
        }
        // TODO
        return false;
    }
}
