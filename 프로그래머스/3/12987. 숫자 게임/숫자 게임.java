import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(B );
        Arrays.sort(A );
        
        // boolean []visit=new boolean[ A.length];
        
        int bidx=0;
        
        for(int v:A){
            
            // System.out.println(v+" "+" "+bidx);
            
            if(bidx>B.length-1){
                break;
            }
            
            
            // if( B[bidx]>v)
            // {
            //     answer++;
            //     bidx++;
            // }
            
            while(bidx<B.length&&B[bidx]<=v){
                    // System.out.println(v+" "+bidx+"ansss");
                // if(bidx>B.length){
                //     break;
                // }
                bidx++;
            }
            
             if(bidx>B.length-1){
                break;
            }
            
            if(B[bidx]>v){
                // System.out.println(v+"iffff "+bidx+"ansss");
                answer++;
                bidx++;
            }
            
        }
        
        return answer;
    }
}

