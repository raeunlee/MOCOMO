import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 작업이 끝나기까지 며칠 걸리는지
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int cnt = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                cnt++;
            }
            queue.add(cnt);
        }
        System.out.println(queue);

        // 배포
        int today = queue.poll();
        int cnt = 1; // 배포되는 작업 수
        while (!queue.isEmpty()) {
            int work = queue.poll();
            if (work <= today) {
                cnt++;
            } else {
                answer.add(cnt);
                today = work;
                cnt = 1;
            }
        }
        answer.add(cnt);

        return answer;
    }
}