package com.test.toss;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

public class RequestFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> hashMap = new HashMap<>();
        String[] strings = scanner.nextLine().split(" ");
        for (String string : strings) {
            if (hashMap.containsKey(string)){
                System.out.print(hashMap.get(string) + " ");
            }else {
//                int temp = Function.compute(Integer.parseInt(string));
//                System.out.print(temp + " ");
//                hashMap.put(string, temp);
            }
        }
    }
}
