package com.test.line;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Karaoke {

    public static void main(String[] args) throws ParseException {
        String[] stdin = {"09:48:42 header free_refills","12:27:05 enter 6",
                "12:32:19 drink alcohol 5978 72",
                "12:43:56 enter 4",
                "14:20:47 food 8304 20",
                "15:26:08 drink soft_drink 3621 11",
                "16:48:38 food 8411 19",
                "18:35:37 enter 3",
                "24:04:39 drink soft_drink 5176 33",
                "25:32:14 footer"};

        int leaveSum = 0;// 퇴장 가격
        Map<String, Map<String, Integer>> map = new HashMap<>();
        map.put("night", new HashMap<>());
        map.get("night").put("one_drink",400);
        map.get("night").put("free_refills",500);
        map.get("night").put("alcohol_free_refills",650);
        map.put("day", new HashMap<>());
        map.get("day").put("one_drink",100);
        map.get("day").put("free_refills",200);
        map.get("day").put("alcohol_free_refills",300);

        int food = 0; // 푸드값
        int drinkSum = 0;
        int drinkCount = 0;
        String drinkMenu = null;
        int peple = 0;// 퇴실 때 사용
        int allPeple = 0; // 음료 주문이 부족할 때 확인용
        int compare = 17 * 3600;
        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

        for (int i = 0; i < stdin.length; i++) {
            String[] split = stdin[i].split(" ");
            switch (split[1]) {
                case "header":
                    drinkMenu = split[2];
                    break;
                case "enter":
                    // 시작 시간 담는알고리즘
                    if (allPeple == 0) {
                        startDate = simpleDateFormat.parse(split[0]);
                    }

                    peple += Integer.parseInt(split[2]);
                    allPeple += Integer.parseInt(split[2]);
                    break;
                case "drink":
                    if (split[2].equals("soft_drink") && drinkMenu.equals("one_drink")) {
                        drinkSum += Integer.parseInt(split[2]) * Integer.parseInt(split[3]);
                    }
                    if (split[2].equals("alcohol") && !drinkMenu.equals("alcohol_free_refills")) {
                        drinkSum += Integer.parseInt(split[3]) * Integer.parseInt(split[4]);
                    }
                    drinkCount += Integer.parseInt(split[4]);
                    break;
                case "food":
                    food += Integer.parseInt(split[2]) * Integer.parseInt(split[3]);
                    break;

                case "leave":
                    int pepleCount = Integer.parseInt(split[2]);

                    Date leaveDate = simpleDateFormat.parse(split[0]);
                    int leave = leaveDate.getHours() * 3600 + leaveDate.getMinutes() * 60 + leaveDate.getSeconds();
                    int start = startDate.getHours() * 3600 + startDate.getMinutes() * 60 + startDate.getSeconds();

                    int startLeave= leave - start /(30*60);
                    leaveSum = getLeaveSum(leaveSum, map, drinkMenu, startDate, pepleCount, start, compare, startLeave);
                    peple -= pepleCount;
                    break;
                case "footer":
                    //시간 계산
                    Date endTime = simpleDateFormat.parse(split[0]);
                    int temp = startDate.getHours() * 3600 + startDate.getMinutes() * 60 + startDate.getSeconds();
                    int end = endTime.getHours() * 3600 + endTime.getMinutes() * 60 + endTime.getSeconds();
                    int result = getLeaveSum(0, map, drinkMenu, startDate, peple, temp, compare, end - temp);

                    result += food + drinkSum + leaveSum;
                    System.out.println(result);
                    break;
                default:
                    System.out.println("{code:999}");
            }

        }

        System.out.println();
    }

    private static int getLeaveSum(int leaveSum, Map<String, Map<String, Integer>> map, String drinkMenu, Date startDate, int pepleCount, int start, int compare, int startLeave) {
        if (startDate.getHours() >=17){
            leaveSum = getLeaveSum(leaveSum, map, drinkMenu, pepleCount, start, compare, startLeave, 3000);
        }else{
            leaveSum = getLeaveSum(leaveSum, map, drinkMenu, pepleCount, start, compare, startLeave, 6600);
        }
        return leaveSum;
    }

    private static int getLeaveSum(int leaveSum, Map<String, Map<String, Integer>> map, String drinkMenu, int pepleCount, int start, int compare, int startLeave, int value) {
        int startCompare = ((compare + value) - start) / (30 * 60);
        if (startLeave == startCompare) {
            if (((compare + value) - start) % (30 * 60) > 10 * 60) {
                leaveSum += pepleCount * map.get("day").get(drinkMenu) * 2;
            } else {
                leaveSum += pepleCount * map.get("day").get(drinkMenu) * 1;
            }
        } else {
            leaveSum += pepleCount * map.get("day").get(drinkMenu) * 1;
            leaveSum += pepleCount * map.get("night").get(drinkMenu) * (startLeave - startCompare);
            if (startLeave % (30 * 60) > 10 * 60) {
                leaveSum += pepleCount * map.get("night").get(drinkMenu);
            }
        }
        return leaveSum;
    }


    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }
}
