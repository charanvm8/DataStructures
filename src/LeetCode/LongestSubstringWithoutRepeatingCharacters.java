package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s == null){
            return 0;
        }
        Set<Character> setArr = new HashSet<>();
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(!setArr.contains(ch)){
                setArr.add(ch);
                maxLength = Math.max(maxLength,setArr.size());
            }
            else{
                //setArr.remove()
            }
        }
        return maxLength;


    }

    public static void main(String[] args){

        String s = "charan";
        System.out.println(s.substring(0,4));
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=s.length();j++){
                //System.out.println("Start "+i+"---End"+j);
            }
        }
    }
}
