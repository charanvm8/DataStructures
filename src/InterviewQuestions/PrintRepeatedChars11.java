package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PrintRepeatedChars11 {


    public static void printRepChars(String s){
        char[] charArray = s.toCharArray();
        Map<Character,Integer> charMap = new HashMap<>();
        for(Character c:charArray){
            if(charMap.keySet().contains(c)){
                charMap.put(c,charMap.get(c)+1);
            }
            else{
                charMap.put(c,1);
            }
        }

        Set<Map.Entry<Character,Integer>> newSet = charMap.entrySet();

        for(Map.Entry<Character,Integer> entry:newSet){
            if(entry.getValue()>1){
                System.out.println(entry.getKey());
            }
        }

    }


    public static void main(String[] args){
        printRepChars("Programming");
    }
}
