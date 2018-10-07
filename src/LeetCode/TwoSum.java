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

    public static void main(String[] args){

        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = twoSum(nums,9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
