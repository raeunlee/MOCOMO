import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int answer = 0;

        // 첫번째 집 털었을 때
        int[] dp1 = new int[n - 1];
        dp1[0] = money[0];
        dp1[1] = money[1];
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        // 두번째 집부터 털었을 때
        int[] dp2 = new int[n];
        dp2[1] = money[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        answer = Math.max(dp1[n - 1], dp2[n]);
        return answer;
    }
}