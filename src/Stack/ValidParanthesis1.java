package Stack;

import java.util.Stack;

public class ValidParanthesis1 {


    public boolean checkForParanthesis(String s){
        Stack<Character> setChars = new Stack();
        for(int i=0;i<s.length();i++){
            char newChar = s.charAt(i);
            if(newChar == '[' || newChar == '(' || newChar == '{'){
                setChars.push(newChar);
            }
            if(newChar == '}' || newChar == ')' || newChar == ']'){
                if(setChars.isEmpty()){
                    return false;
                }
                char head = setChars.pop();
                char getPartner = getPartner(newChar);
                if(head!=getPartner){
                    return false;
                }
            }

        }

        if(setChars.isEmpty()){
            return true;
        }
        return false;
    }

    public static char getPartner(char i){
        char c = i;
        if(i == ']') {
            c ='[';
        }
        if(i == '}') {
            c = '{';
        }
        if(i == ')'){
           c = '(';
        }
        return c;
    }
}
