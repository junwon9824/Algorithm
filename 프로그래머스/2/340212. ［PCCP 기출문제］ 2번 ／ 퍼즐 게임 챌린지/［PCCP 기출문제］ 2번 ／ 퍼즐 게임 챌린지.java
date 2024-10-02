class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        long answer = Long.MAX_VALUE;
        
        // timecur+timeprev
        
        // result 숙련도 diff 가 숙련도 보다 작은경우 그냥진행.
        
        long sum=0;
        
        sum+= times[0];
        long tmp=sum;
        
        long l=1;
        long r=limit;
        
        while(l<=r){
            
            long mid=(l+r)/2; //숙련도
            tmp=sum;
            
            for(int i=1;i< diffs.length ;i++){
                if( diffs[i]>mid ) 
                    tmp+=  (times[i]+times[i-1]  )*(diffs[i]-mid )+times[i] ;
               
                else
                    tmp+=times[i];

            }
            System.out.println(answer+" ssss"+" m  "+mid+" tt  "+tmp+"  l" +l+" r "+r);
            
            if(tmp<=limit ){ //제한시간안에 들어
                
                 answer=Math.min(answer,mid);
                r=mid-1;
                System.out.println(answer+" "+" m  "+mid+" tt  "+tmp+"  l" +l+" r "+r);
              // return answer;
                
            }
            
            else{
                l=mid+1;
                
            }
            
        }
        
        
        return answer;
    }
    
}