package LeetCode;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        if(s.length()<2){
            return 1;
        }
        int k = 1;
        String result = s.substring(0,1);
        for(int j=1;j<s.length()-1;j++){
            if(result.indexOf(s.charAt(j)) == -1){
                result = result + s.substring(j,j+1);
                k = result.length() > k ? result.length():k;
            }
            else{
                result = s.substring(j,j+1);
            }
        }
        return k;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
