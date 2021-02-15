package Stack;

import java.util.*;

public class ScoreOfParentheses {

    public static int scoreOfParentheses(String S) {
        return 0;
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//        queue.add(10);
//        queue.add(20);
//        for(Integer q:queue){
//            System.out.println(queue);
//        }
        Set<Integer> dsfa = new HashSet<>();
        dsfa.add(10);
        Iterator itr = dsfa.iterator();
        Integer z = 0;

        while (itr.hasNext()){
            z = (int)itr.next();
        }
        System.out.println(z);
        Stack<Integer> s = new Stack<>();
        System.out.println(Math.floorMod(-2,2));
    }
}
