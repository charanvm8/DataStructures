package LeetCode;

import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s==null){
            return false;
        }
        List<String> validParent = new Stack<>();
        for(int i=0;i<s.length()-1;i++){
            if(s.substring(i,i+1).equals("{") || s.substring(i,i+1).equals("[") || s.substring(i,i+1).equals("(")){
                //validParent.push(s.substring(i,i+1));
            }
        }
        return false;
    }

    public static void main(String[] args){

    }
}
