import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int M, N, H;
    static int arr[][][];
    static Queue<int[]> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        arr = new int[H][N][M];
        queue = new LinkedList<>();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[k][i][j] == 1) {
                        queue.add(new int[]{k, i, j});
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int h = tmp[0];
            int x = tmp[1];
            int y = tmp[2];
            for (int i = 0; i < 6; i++) {
                int newH = h + dh[i];
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newH >= 0 && newH < H && newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (arr[newH][newX][newY] == 0) {
                        arr[newH][newX][newY] = arr[h][x][y] + 1;
                        queue.add(new int[]{newH, newX, newY});
                    }
                }
            }
        }

        // 안익은 토마토가 있는지 확인
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[k][i][j] == 0) {
                        return -1;
                    }
                }
            }
        }

        // 며칠 걸리는지 확인
        int result = 0;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    result = Math.max(result, arr[k][i][j]);
                }
            }
        }
        return result - 1;
    }
}