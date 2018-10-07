package LeetCode;

public class ReverseInteger {

    public static int reverse(int x) {
        long result = 0;
        while(x!=0){
            int temp = x%10;
            x = x/10;
            result = result * 10 +temp;

        }
        if (result >Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;

        return (int)result;
    }

    public static void main(String[] args){
        System.out.println(reverse(-123));
    }
}
