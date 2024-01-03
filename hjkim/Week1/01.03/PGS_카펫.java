class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for (int i = 3; i * i <= sum; i++) {
            if (sum % i == 0) {
                int a = i - 2; // 노란칸 가로길이
                int b = (sum / i) - 2; // 노란칸 세로길이
                if (a * b == yellow) {
                    answer[0] = sum / i;
                    answer[1] = i;
                    break;
                }
            }
        }
        return answer;
    }
}