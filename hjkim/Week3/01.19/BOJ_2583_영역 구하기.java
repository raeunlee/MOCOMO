import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Integer> result;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new boolean[m][n];
        result = new ArrayList<>();

        for (int h = 0; h < k; h++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    cnt = 1;
                    visited[i][j] = true;
                    result.add(dfs(i, j));
                }
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int i : result) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    static public int dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (arr[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                    cnt++;
                    visited[nextY][nextX] = true;
                    dfs(nextY, nextX);
                }
            }
        }
        return cnt;
    }
}