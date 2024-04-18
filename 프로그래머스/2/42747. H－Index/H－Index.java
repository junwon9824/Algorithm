import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // citations=new int[]{3,4};
        
        int size=citations.length;
        
        // h+(h이하)=size
        // h가반이상은되야돼
        
         Arrays.sort(citations);
        //100 200 300  
        
        for(int i=0;i<size ;i++){
            
            if( citations[i] >= size-i  ){
                return size-i;

            }
            
        }
        return answer;
        
    }
    
}