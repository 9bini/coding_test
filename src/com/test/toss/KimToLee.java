package com.test.toss;

import java.util.Scanner;

public class KimToLee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kims = scanner.nextLine().split(" ");
        String[] lees = scanner.nextLine().split(" ");
        int keep = 0;
        for (int i = 0; i < kims.length; i++) {
            int kim = Integer.parseInt(kims[i]);
            int lee = Integer.parseInt(lees[i]);

            int cal = kim - lee;
            if (cal <  0 ) {
                System.out.print(0);
                keep -= cal;
            }
            else{
                if (keep >=cal){
                    System.out.print(0);
                    keep -=cal;
                }else{
                    System.out.print(cal - keep);
                    keep = 0;
                }
            }
            System.out.print(" ");
        }
    }
}
