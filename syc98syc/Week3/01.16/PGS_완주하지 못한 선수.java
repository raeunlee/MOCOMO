import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        int index = participant.length-1;
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<participant.length-1; i++){
            if(!participant[i].equals(completion[i])){
                index=i;
                break;
            }
        }
        
        return participant[index];
    }
}
