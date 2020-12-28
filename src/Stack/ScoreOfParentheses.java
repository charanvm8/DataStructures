package Stack;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class ScoreOfParentheses {

    public static int scoreOfParentheses(String S) {
        return 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(10);
        queue.add(20);
        for(Integer q:queue){
            System.out.println(queue);
        }
    }
}
