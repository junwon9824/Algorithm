class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        //w 는 거리 , 몇개더설치해야하냐
        //홀수면커버가능,짝수면두개무조건필요
        int cur=1;
        int idx=0;
        
        while(cur<=n ){
             
            if(idx<stations.length && stations[idx]-w <= cur ){ // 기존 기지국이 커버 하는경우
                cur=stations[idx]+w+1;
                // answer++;
                idx++;
            }
            
            else  { // 커버안되는경우
                cur+=2*w+1;
                answer++;
                
            }
            
        }
        
        
        System.out.println("Hello Java");

        return answer;
    }
}