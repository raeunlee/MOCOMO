import java.util.*;

public class Solution {
    public Stack solution(int []arr) {
        Stack st = new Stack();
        
        for(int i=0; i<arr.length; i++){
            if (st.isEmpty()==true)
                st.push(arr[i]);
            if(!st.peek().equals(arr[i])){
                st.push(arr[i]);
            }
        }
        return st;
    }
}
