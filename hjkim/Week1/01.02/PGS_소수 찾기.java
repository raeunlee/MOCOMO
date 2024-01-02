import java.util.*;

class Solution {
    static String[] arr;
    static String[] output;
    static boolean[] visited;
    static Set<Integer> answer;

    public int solution(String numbers) {
        answer = new HashSet<>();
        int len = numbers.length();
        arr = new String[len];
        arr = numbers.split("");
        output = new String[len];
        visited = new boolean[len];

        for (int i = 0; i < numbers.length(); i++) {
            permutation(arr, output, visited, 0, i + 1);
        }
        return answer.size();
    }

    // 문자열 순열
    public void permutation(String arr[], String output[], boolean visited[], int depth, int r) {
        if (depth == r) {
            String str = "";
            for (int i = 0; i < r; i++) {
                str += output[i];
            }
            if (isPrime(Integer.parseInt(str))) {
                answer.add(Integer.parseInt(str));
            }
            // System.out.println(str);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}