package InterviewQuestions;

import java.util.List;

public class ReverseArrayInPlace14 {

    public static void revArray(String[] array){
        if(array.length<2 || array == null){
            return;
        }
        int arrLen = array.length;
        for(int i=0;i<arrLen/2;i++){
            String temp = array[i];
            array[i] = array[arrLen-1-i];
            array[arrLen-1-i] = temp;
        }

    }
}
