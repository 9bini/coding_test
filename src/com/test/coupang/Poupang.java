package com.test.coupang;

import java.util.HashSet;
import java.util.Set;

import java.util.*;

public class Poupang {

    static int result = 0;
    static boolean[] visit;
    static int[] map;
    static int N;
    static int minCount;
    static int maxTal;

    public int solution(int[] arr, int k, int t) {
        map = arr;
        N = arr.length;
        visit = new boolean[N];
        minCount = k;
        maxTal = t;
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            dfs(1, map[i], i);
            visit[i] = false;
        }
        return result;
    }


    private void dfs(int count, int total, int pos) {
        if (count >= minCount && total <= maxTal) result += 1;
        for (int i = pos; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(count + 1, total + map[i], i);
                visit[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[][] p = new int[][]{
                {2, 5, 3, 8, 1},
                {1, 1, 2, 2},
                {1, 2, 3, 2}
        };
        int[][] p2 = new int[][]{
                {3, 11},
                {2, 3},
                {2, 2}
        };
        int i = 2;
        System.out.println(new Poupang().solution(p[i], p2[i][0], p2[i][1]));
    }
}
