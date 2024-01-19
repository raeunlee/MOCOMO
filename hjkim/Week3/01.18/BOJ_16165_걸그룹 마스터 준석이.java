import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 걸그룹 수
        int m = Integer.parseInt(st.nextToken()); // 문제 수
        Map<String, String[]> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String group = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String[] mem = new String[size];
            for (int j = 0; j < size; j++) {
                mem[j] = br.readLine();
            }
            Arrays.sort(mem);
            map.put(group, mem);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 1) { // 그룹 이름 출력
                for (String key : map.keySet()) {
                    for (String value : map.get(key)) {
                        if (name.equals(value)) {
                            sb.append(key).append("\n");
                        }
                    }
                }
            } else { // 그룹 전체 출력
                for (String s : map.get(name)) {
                    sb.append(s).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}