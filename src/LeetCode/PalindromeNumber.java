package LeetCode;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int a = x;
        int res = 0;
        while(a != 0){
            res = res*10 + a % 10;
            a = a /10;
        }
        return res == x;

    }

    public static void main(String[] args){
        System.out.println(isPalindrome(121));

    }
}
