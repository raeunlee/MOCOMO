import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16165 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new  StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<String,String>();
		ArrayList<String> ans = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());
			for(int j=0; j<num; j++) {
				String name = br.readLine();
				map.put(name, team);
			}
		}
		
		
		for(int i=0; i<M; i++) {
			String teamOrName = br.readLine();
			int question = Integer.parseInt(br.readLine());
			if(question==1)
				System.out.println(map.get(teamOrName));
			else if(question==0) {
				ans.clear();
				for(String key : map.keySet()) {
					if(map.get(key).equals(teamOrName))
						ans.add(key);
				}
				Collections.sort(ans);
				for(int j=0; j<ans.size();j++)
					System.out.println(ans.get(j));
			}
		}
		
	}

}
