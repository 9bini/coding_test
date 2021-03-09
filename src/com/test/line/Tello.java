package com.test.line;

import java.util.*;

public class Tello {

    static int shop = Integer.MIN_VALUE;
    static int shool = Integer.MAX_VALUE;
    static Set<Integer> shopMap;
    static Set<Integer> visitz;
    static HashMap<Integer, Integer> tellMap;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        int N = Integer.parseInt(s1[0]);
        int M = Integer.parseInt(s1[1]);
        int S = Integer.parseInt(s1[2]);
        int T = Integer.parseInt(s1[3]);


        shopMap = new HashSet<>();
        tellMap = new HashMap<>();

        String[] s2 = scanner.nextLine().split(" ");
        for (int i = 0; i < N; i++) shopMap.add(Integer.parseInt(s2[i]));

        String[] s3 = scanner.nextLine().split(" ");
        for (int i = 0; i < M; i++) {
            tellMap.put(i, Integer.parseInt(s3[i]));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

            }
        }
    }

    public static void cur(int T, int S, int pos, int count, int buy, int M) {
        if (pos == S) {
            if (shop < buy) shop = buy;
            if (shool > count) shool = count;
            return;
        }
        if (count >= T) return;
        // 도보

        cur(T, S, pos + 1, count + 1, buy, M);
        if (pos > 0)
            cur(T, S, pos - 1, count + 1, buy, M);

        // 가계
        if (shopMap.contains(pos))
            cur(T, S, pos, count + 1, buy + 1, M);

        //텔포
        if (tellMap.containsValue(pos))
            for (int i = 0; i < M; i++) {
            {
                Integer tellPosision = tellMap.get(i);
                if (pos != tellPosision)
                    cur(T, S, tellPosision, count, buy, M);
            }
        }
    }
}
