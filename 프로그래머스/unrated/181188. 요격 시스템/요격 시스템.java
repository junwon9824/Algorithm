import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<point> pq=new PriorityQueue<>();
        
        int r=targets.length;
        int c=targets[0].length;
        
        for(int i=0;i<r;i++)
        {
             pq.add(new point(targets[i][0],targets[i][1]));

        }
        
        int last=-1;
        while(!pq.isEmpty())
        {
            point  v=pq.poll();
            int s=v.s;
            int e=v.e;
            
            if(last <= s)
            {
                last=e;
                System.out.println(last);
                answer++;
            }
            
        }
             
        return answer;
    }
    
    static class point implements Comparable<point> {
    int s,e;
        public point(int s,int e)
        {
            this.e=e;
            this.s=s;
        }
        @Override
        public int compareTo(point o)
        {
                          
                return this.e-o.e;
 
        }
        
    }
}