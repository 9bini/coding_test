package com.test.toss;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
        String[] s = next.split(" ");
        if (s.length != 6){
            System.out.println("false");
            return;
        }
        Set<Integer> set = new HashSet<>();
        int pre = 0;
        for (String s1 : s) {
            int e = Integer.parseInt(s1);
            if (set.contains(e)){
                System.out.println("false");
                return;
            }else{
                set.add(e);
                if (pre > e || e >45){
                    System.out.println("false");
                    return;
                }
                pre = e;
            }
        }
        System.out.println("true");
    }
}
