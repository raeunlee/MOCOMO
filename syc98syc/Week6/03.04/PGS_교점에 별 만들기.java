import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        List<long[]> list = new ArrayList<>(); 
        long minX= Long.MAX_VALUE;
        long maxX= Long.MIN_VALUE;
        long minY= Long.MAX_VALUE;
        long maxY= Long.MIN_VALUE;
        
        for(int i=0; i<line.length; i++){
            long a=line[i][0];
            long b=line[i][1];
            long e=line[i][2];
            
            for(int j=i+1; j<line.length; j++){
                long c=line[j][0];
                long d=line[j][1];
                long f=line[j][2];
                
                long bfed=b*f-e*d;
                long adbc=a*d-b*c;
                long ecaf=e*c-a*f;
                
                if(adbc!=0){
                    double x=(double)bfed/adbc;
                    double y=(double)ecaf/adbc;
                                    
                if(x==Math.ceil(x)&& y==Math.ceil(y)){
                    list.add(new long[]{(long)x,(long)y});
                    minX= Math.min(minX,(long)x);
                    minY= Math.min(minY,(long)y);
                    maxX= Math.max(maxX, (long)x);
                    maxY= Math.max(maxY, (long)y);
                }
                }

            }
        }

        
        boolean array2D[][] = new boolean[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
        for(long[] intT: list){
            int x= (int)(intT[0]-minX);
            int y= (int)(intT[1]-maxY);
            array2D[Math.abs(y)][x]=true;
        }
        
        answer=new String[array2D.length];
        int i=0;
        for(boolean[] ba: array2D){
            StringBuilder sb = new StringBuilder();
            for(boolean b: ba){
                if(b)
                    sb.append("*");
                else
                    sb.append(".");
            }
            
        answer[i++]=sb.toString();
        }
        
        
        return answer;
    }
}
