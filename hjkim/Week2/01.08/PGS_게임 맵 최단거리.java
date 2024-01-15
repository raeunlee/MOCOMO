import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int count = tmp[2];
            //System.out.println("x: "+x+" y: "+y +" count: "+count);

            if (x == n - 1 && y == m - 1) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY, count + 1});
                    }
                }
            }
        }
        // 도착할 수 없을 때
        return -1;
    }
}