package com.test.line;

public class maturi {
    public static void main(String[] args) {
        // Setting
        String[] s = args[0].split(" ");
        int n =  Integer.parseInt(s[0]);
        int h =  Integer.parseInt(s[1]);
        int w =  Integer.parseInt(s[2]);
        int x =  Integer.parseInt(s[3]);
        int y =  Integer.parseInt(s[4]);
        int z =  Integer.parseInt(s[5]);

        int[] peples = new int[n];
        String[] tempString = args[1].split(" ");
        for (int i = 0; i < n; i++) peples[i] = Integer.parseInt(tempString[i]);

        String[][] map = new String[h][w];
        boolean[][] visits = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String[] split = args[2 + i].split("");
            for (int j = 0; j < w; j++) map[i][j] = split[j];
        }

        // Arrangement
        for (int i = 0; i < n; i++) {
            // 사람, 시작 알파벳
            dfs(peples,map,i, visits, h, w);
        }

    }

    private static void dfs(int[] peples, String[][] map, int i, boolean[][] visits, int h, int w) {

    }

}
