package Stack;

import java.util.Stack;
import java.util.*;

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

    public static void getValues(){
        Map<String,String> falUserGroups = new HashMap<>();
        Map<String,String> fboUserGroups = new HashMap<>();
        Map<String,String> fpdsUserGroups = new HashMap<>();
        Map<String,Map<String,String>> userGroupsMSTR = new HashMap<>();

        fboUserGroups.put("Contract Opportunities Grand User","FBO_GRAND_USER");
        fboUserGroups.put("Contract Opportunities Administrator","FBO_ADMIN");
        fboUserGroups.put("Contracting Specialist","FBO_CO_SPECIALIST");
        fboUserGroups.put("Contracting Officer","FBO_CO_OFFICER");


        falUserGroups.put("Assistance Listing Grand User","ASSISTANCE_LISTING_GRAND_USER");
        falUserGroups.put("Assistance Administrator","ASSISTANCE_ADMIN");
        falUserGroups.put("Assistance User","ASSISTANCE_USER");
        falUserGroups.put("OMB Administrator","OMB_ADMIN");
        falUserGroups.put("OMB Analyst","OMB_ANALYST");

        fpdsUserGroups.put("Contract Data Grand User","CONTRACT_DATA_GRAND_USER");
        fpdsUserGroups.put("NASA Contracting Officer Administrator","NASA_CO_ADMIN");
        fpdsUserGroups.put("DOD Contracting Officer Administrator","DOD_CO_ADMIN");
        fpdsUserGroups.put("Contracting Officer Administrator","CO_ADMIN");
        fpdsUserGroups.put("NASA Contracting Specialist","NASA_CONTRACTING_OFFICER");
        fpdsUserGroups.put("DOD Contracting Specialist","DOD_CONTRACTING_OFFICER");
        fpdsUserGroups.put("Contracting Specialist","CONTRACTING_OFFICER");
        fpdsUserGroups.put("NASA Contracting Officer","NASA_CONTRACTING_OFFICER");
        fpdsUserGroups.put("DOD Contracting Officer","DOD_CONTRACTING_OFFICER");
        fpdsUserGroups.put("Contracting Officer","CONTRACTING_OFFICER");

        userGroupsMSTR.put("Contract Opportunities",fboUserGroups);
        userGroupsMSTR.put("Assistance Listing",falUserGroups);
        userGroupsMSTR.put("Contract Data",fpdsUserGroups);
        System.out.println(userGroupsMSTR);
    }

    public static void main(String[] args){
        System.out.println(validParenthesis("()"));
        getValues();
    }
}
