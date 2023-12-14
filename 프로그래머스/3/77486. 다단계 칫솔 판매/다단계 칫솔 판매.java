import java.util.*;

class Solution {

    static class Point {
        String name;
        int money;

        public Point(String name, int money) {
            this.name = name;
            this.money = money;
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int profit = amount[i] * 100;

            while (!current.equals("-") && profit > 0) {
                int share = profit / 10;
                int currentProfit = profit - share;

                answer[indexMap.get(current)] += currentProfit;
                profit = share;
                current = parentMap.get(current);
            }
        }
        return answer;
    }
}
