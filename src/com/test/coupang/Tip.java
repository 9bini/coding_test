package com.test.coupang;

public class Tip {
    public static void main(String[] args) {
        Tip tip = new Tip();
        tip.sol(3, new int[][]{{1, 5}, {8, 3}, {4, 2}, {2, 3}, {3, 1}, {3, 2}, {4, 2}, {5, 2}, {4, 1}});
    }

    public int sol(int r, int[][] arr) {
        boolean[] visits = new boolean[r * r];

        return rec(visits, r, arr, 0, 0);
    }

    private int rec(boolean[] visits, int r, int[][] arr, int x, int y) {
        visits[x * r + y] = true;
        if (x < r && !visits[(x + 1) * r + y]) {
            rec(visits, r, arr, x + 1, y);
        }
        if (y < r && !visits[x * r + (y + 1)]) {
            rec(visits, r, arr, x, y + 1);
        }
        if (0 < x && !visits[(x - 1) * r + y]) {
            rec(visits, r, arr, x - 1, y);
        }
        if (0 < y && !visits[x * r + (y - 1)]) {
            rec(visits, r, arr, x, y - 1);
        }
        return 0;
    }

}
