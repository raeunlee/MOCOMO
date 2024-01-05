class Solution {
    static boolean[] visited;
    static int count;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않고, 최소 필요 피로도 보다 클 때
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        count = Math.max(count, depth);
    }
}