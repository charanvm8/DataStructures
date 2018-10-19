package Stack;

import java.util.Stack;

public class ValidParanthesis {

    public static boolean validParenthesis(String s){
        char[] chars=s.toCharArray();
        Stack<Character> k = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '{' || chars[i] == '[' || chars[i] == '('){
                k.push(chars[i]);
            }
            if(chars[i] == '}' || chars[i] == ']' || chars[i] == ')'){
                if(k.isEmpty()){
                    return false;
                }
                else if(!checkForRightParent(chars[i], k.pop())){
                    return false;
                }
            }
        }
        if(k.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkForRightParent(Character c,Character s){
        if(c == '}' && s == '{'){
            return true;
        }
        else if(c == ']' && s == '['){
            return true;
        }
        else if(c == ')' && s == '('){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println(validParenthesis("()"));
    }
}
