import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            boolean b = map.containsKey(clothes[i][1]);
            if(b==false)
                map.put(clothes[i][1],1);
            else{
                int n= map.get(clothes[i][1]);
                map.put(clothes[i][1],n+1);
            }
        }
        
        Iterator<String> keys = map.keySet().iterator();
        while (keys.hasNext()){
            String key = keys.next();
            answer *= (map.get(key)+1);
        }
        
        answer --;
        return answer;
    }
}
