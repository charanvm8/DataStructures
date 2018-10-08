package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        return "";
    }

    public static void main(String[] args){

        String s = "Dileep";
        String s2 = "CharanMareedu";
        System.out.println("Test"+s.charAt(0));
        while(s2.indexOf(s)!=0){
            s = s.substring(0,s.length()-1);
            if(s.isEmpty()){
                System.out.println("i"+s);
            }
        }

        System.out.println(s);
    }
}
