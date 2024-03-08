class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        
        int num=1;
        int x=-1;
        int y=0;
        int array[][]= new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){
                    x++;
                }
                else if(i%3==1){
                    y++;
                }
                else{
                    x--;
                    y--;
                }
                array[x][y]=num++;
            }
        }
        
        int k=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(array[i][j]==0) break;
                answer[k++]=array[i][j];
            }
        }
        
        return answer;
    }
}
