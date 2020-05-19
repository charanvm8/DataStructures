package geeksForGeeks.java.module1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ScannerIn {

    public static void main(String[] args) {
        Set<Integer> hs =new HashSet<Integer>();
        hs.add(3);
        hs.add(4);
        hs.add(3);
        hs.add(5);
        hs.add(4);
        hs.add(6);
        hs.remove(5);
        System.out.print(Collections.frequency(hs, 5));
    }
}
