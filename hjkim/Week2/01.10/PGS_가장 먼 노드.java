import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxDis = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distance = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int next : graph.get(node)) {
                    if (distance[next] == 0) {
                        queue.add(next);
                        distance[next] = distance[node] + 1;
                        maxDis = distance[next];
                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (distance[i] == maxDis) answer++;
        }
        return answer;
    }
}