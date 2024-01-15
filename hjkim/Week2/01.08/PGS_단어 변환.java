import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(begin);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return answer;
                }

                // 알파벳 한개만 다른지 확인
                for (int i = 0; i < words.length; i++) {
                    int notEql = 0;
                    for (int j = 0; j < curr.length(); j++) {
                        if (curr.charAt(j) != words[i].charAt(j)) {
                            notEql++;
                        }
                    }
                    if (!visited[i] && notEql == 1) {
                        visited[i] = true;
                        queue.add(words[i]);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
}