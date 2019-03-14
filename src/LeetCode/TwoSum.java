package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            int result = target - nums[i];
            if(numMap.containsKey(result)){
                return new int[]{numMap.get(result),i};
            }
            numMap.put(nums[i],i);
        }
        return null;
    }

    private static String getRandomString(int var1) {
        char[] var2 = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder var3 = new StringBuilder();

        for(int var4 = 0; var4 < var1; ++var4) {
            var3.append(var2[(int)Math.floor(Math.random() * (double)var2.length)]);
        }

        return var3.toString();
    }

    public static void main(String[] args){

//        int[] nums = new int[]{2, 7, 11, 15};
//        int[] result = twoSum(nums,9);
//        System.out.println(result[0]);
//        System.out.println(result[1]);

        System.out.println(getRandomString(12));




    }
}
