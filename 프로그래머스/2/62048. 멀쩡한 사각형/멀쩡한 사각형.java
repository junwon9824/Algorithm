class Solution {
    
    static int gcd(int a,int b)
    {
        
        if(b==0)
        {
            return a;
        }
        
        else{
            return gcd(b,a%b);
        }
        
    }
    
    public long solution(int w, int h) {
        long answer = 1;
        
        answer =(long) w*h;
        
        answer-=(long) w+h;
        answer+=gcd(w,h);
        
        
        return answer;
    }
    
    
}