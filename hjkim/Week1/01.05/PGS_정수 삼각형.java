import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            // 맨 왼쪽
            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }

            // 맨 오른쪽
            dp[i][i] = triangle[i][i] + dp[i - 1][i - 1];
        }
        for (int n : dp[triangle.length - 1]) {
            answer = Math.max(answer, n);
        }
        return answer;
    }
}