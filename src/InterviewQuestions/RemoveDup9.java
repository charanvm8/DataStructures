package InterviewQuestions;

import java.util.ArrayList;
import java.util.*;

public class RemoveDup9 {




    public static void main(String[] args){

        List<Integer> primes = new ArrayList<>();

        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);  //duplicate
        primes.add(7);
        primes.add(11);

        Set<Integer> newPrimes = new LinkedHashSet<>(primes);


        primes.clear();
        primes.addAll(newPrimes);

        System.out.println(primes);

    }
}
