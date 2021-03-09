package com.test.coupang;

public class Delivery {
    static Pos[][] map;
    static boolean[][] visited;
    static int maxTime;
    static int result = 0;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int r, int[][] delivery) {
        map = new Pos[r][r];
        N = r;
        visited = new boolean[r][r];
        maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < r * r; i++) {
            maxTime = Math.max(maxTime, delivery[i][0]);
            map[i / r][i % r] = new Pos(delivery[i][0], delivery[i][1]);
        }
        visited[0][0] = true;

        dfs(0, 0, 0, map[0][0].value, 1);
        return result;
    }

    private void dfs(int x, int y, int time, int value, int visitCount) {
        if (maxTime-1 == time) {
            System.out.println(visited);
            result = Math.max(value, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nValue = 0;
            
        }
    }

    public static void main(String[] args) {
        Delivery delivery = new Delivery();
        System.out.println(delivery.solution(3, new int[][]{{1, 5}, {8, 3}, {4, 2}, {2, 3}, {3, 1}, {3, 2}, {4, 2}, {5, 2}, {4, 1}}));
    }

    static class Pos {
        int time;
        int value;

        public Pos(int time, int value) {
            this.time = time;
            this.value = value;
        }
    }
}
