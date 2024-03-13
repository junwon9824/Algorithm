class Solution {
    static int answer2=0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        sub(target,0,0, numbers.length,numbers);  
        answer=answer2;
        return answer;
    }
    
    static void sub(int target,int d,int sum,int size,int []numbers){
        if(d==size){
            if(target==sum)
                answer2++;
            return;
        }
        
        sub( target,d+1,sum+numbers[d] ,size,numbers );
        sub( target,d+1,sum-numbers[d] ,size,numbers );
    }
    
}
