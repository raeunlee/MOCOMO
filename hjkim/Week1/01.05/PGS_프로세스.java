import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
            idxQueue.add(i);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int curr_idx = idxQueue.poll();
            boolean ck = false; // 뒤에 더 큰 우선순위가 있는지 확인
            for (int p : queue) {
                if (curr < p) {
                    ck = true;
                    break;
                }
            }
            if (ck) {
                queue.add(curr);
                idxQueue.add(curr_idx);
            } else {
                answer++;
                if (curr_idx == location) {
                    break;
                }
            }
        }
        return answer;
    }
}