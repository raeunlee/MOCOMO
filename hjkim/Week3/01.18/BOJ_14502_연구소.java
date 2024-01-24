import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static int maxSafeZone = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSafeZone);
    }

    public static void dfs(int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(wallCnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 원본 배열 유지위해 배열 카피
        int[][] copyArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyArr[i] = arr[i].clone();
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int y = tmp[0];
            int x = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (copyArr[nextY][nextX] == 0) {
                        queue.add(new int[]{nextY, nextX});
                        copyArr[nextY][nextX] = 2;
                    }
                }
            }
        }

        // safezone 확인
        funcSafeZone(copyArr);
    }

    public static void funcSafeZone(int[][] copyArr) {
        int safeZone = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArr[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        maxSafeZone = Math.max(safeZone, maxSafeZone);
    }
}