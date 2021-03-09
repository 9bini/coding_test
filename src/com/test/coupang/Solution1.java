package com.test.coupang;

import java.util.*;

public class Solution1 {

    /*
     * 물건의 낱개 가격 100 ~ 100,000 쿠폰 할인율 1~100 중복 x 가격, 수량 / 할인 / 수량 낱개 물건마다 최대 1개 쿠폰
     * 적용 가능 물건의 가격은 100단위 증가 가격이 정수로 나뉘어 떨어진다.
     */

    public static void main(String[] args) {
        int[][] goods = {{25400, 2}, {10000, 1}, {31600, 1}};
        int[][] coupons = {{5, 3}};

        Arrays.sort(goods, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(coupons, (o1, o2) -> o2[0] - o1[0]);

        int result = 0;
        Queue<Integer> goodsQ = qInsert(goods);
        Queue<Integer> couponsQ = qInsert(coupons);

        for (int i : goodsQ) {
            if (!couponsQ.isEmpty()) {
                result += (i - (i / 100) * couponsQ.poll());
            }else{
                result +=i;
            }
        }
        System.out.println(result);
    }

    private static Queue<Integer> qInsert(int[][] arr) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i][1]; j++)
                q.offer(arr[i][0]);

        return q;
    }

    public long solution(int[][] goods, int[][] coupons) {
        Arrays.sort(goods, (o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(coupons, (o1, o2) -> o2[0] - o1[0]);
        return getSum(goods, coupons);
    }

    private long getSum(int[][] goods, int[][] coupons) {
        int sum = 0;
        int couponsIndex = 0;
        int couponsSize = coupons.length;
        for (int i = 0; i < goods.length; i++) {
            int goodLength = goods[i][1];
            for (int j = 0; j < goodLength; j++, goods[i][1] -= 1, coupons[couponsIndex][1] -= 1) {
                if (couponsIndex == couponsSize) return sum + restSum(goods, i);
                if (coupons[couponsIndex][1] == 0) couponsIndex += 1;
                sum += goods[i][0] - ((goods[i][0] / 100) * coupons[couponsIndex][0]);
            }
        }
        return sum;
    }

    private int restSum(int[][] goods, int i) {
        int sum = 0;
        for (int j = i; j < goods.length; j++) {
            sum += goods[j][0] * goods[j][1];
        }
        return sum;
    }
}
