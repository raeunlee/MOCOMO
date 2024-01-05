import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long start = times[0];
        long end = (long) n * times[times.length - 1];
        long answer = end;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0; // 심사 가능한 사람 수
            for (int t : times) {
                cnt += mid / t; // 각 심사관이 심사할 수 있는 사람 수
                if(cnt >= n) break;
            }

            if (cnt < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}