class Solution {
    static int n;
    static int[][] computers;
    static boolean[] visited;
    static int answer;

    public int solution(int num, int[][] computer) {
        n = num;
        computers = computer;
        visited = new boolean[n];
        answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(i);
            }
        }
    }
}