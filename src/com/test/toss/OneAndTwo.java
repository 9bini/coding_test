package com.test.toss;

import java.util.Scanner;

public class OneAndTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int after = num % 10;
        num/=10;
        if (after == 1){
            System.out.println("false");
            return;
        }
        while (num >0){
            int temp = num % 10;
            num/=10;
            if ((after == 1 && temp ==1)){
                System.out.println("false");
                return;
            }

        }


        System.out.println("true");
    }
}
