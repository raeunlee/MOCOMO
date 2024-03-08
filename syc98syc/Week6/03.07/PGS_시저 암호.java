import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int[] arr = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0; i<s.length(); i++){
            arr[i]=(int)s.charAt(i);
            if(arr[i]==32){
                sb.append(" ");
                continue;
            }
            if(arr[i]<=90){
                arr[i]+=n;
                if(arr[i]>90)
                    arr[i]-=26;
            }
            if(arr[i]>=97){
                arr[i]+=n;
                if(arr[i]>122)
                    arr[i]-=26;
            }
            
            sb.append((char)arr[i]);
        }
        
        answer=sb.toString();
        return answer;
    }
}
