package com.test.toss;

import java.util.*;

public class Remember {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            if (list.contains(s)){
                list.remove(s);
            }
            list.add(s);
            int size = list.size();
            int temp = size < 5 ? size : 5;
            for (int i = 0; i < temp; i++) {
                System.out.print(list.get(size-i-1) + " ");
            }
            System.out.println();
        }
    }
}
