class Solution {
    public int solution(int[] numbers) {
        
        int answer = -1;
        int []num=new int[10];
        
        for(int v:numbers){
            System.out.println(v);
            num[v]++;
        }
        
        int sum=0;
        
        for(int i=0;i<10;i++){
            
            if(num[i]==0 )
            {
                sum+= i;    
            }
            
        }
        
        answer=sum;
        
        return answer;
    }
    
}