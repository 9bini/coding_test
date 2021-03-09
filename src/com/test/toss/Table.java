package com.test.toss;

import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(";");
        int ans = 0;
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split[0].length(); j+=2) {
                char c = split[i].charAt(j);
                if (c == '1'){
                    if (split[i+1].charAt(j) != '1') ans+=1;
                    if (split[i].charAt(j+2) != '1')ans+=1;
                    if (split[i].charAt(j-2) != '1')ans+=1;
                    if (split[i-1].charAt(j) != '1')ans+=1;
                }
            }
        }
        System.out.println(ans);
    }
}
