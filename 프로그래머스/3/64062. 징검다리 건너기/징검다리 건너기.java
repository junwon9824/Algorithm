
class Solution {
    
   public int solution(int[] stones, int k) {
       
        int min = 0;
        int max = Integer.MAX_VALUE;
        int result = 0;
       
        while(min <= max) {
                // System.out.println("min max"+min+" "+max);
            
            int mid = (min + max) / 2;
            
            if(check(mid, k, stones)) {
                min = mid + 1;
                // System.out.println(min);
                result = mid;
            } 
            
            else {
                max = mid - 1;
                // System.out.println("max"+max);
            }
            
        }
       
        return result;
    }
    
    public boolean check(int mid, int k, int[] stones) {
        
        int count = 0;
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < mid) { //mid보다 작으면 mid가 건널 수 없다.
                count++;
                if(count >= k) return false;
            } else count = 0;
        }
        
        return true;
        
    }
    
    
}
