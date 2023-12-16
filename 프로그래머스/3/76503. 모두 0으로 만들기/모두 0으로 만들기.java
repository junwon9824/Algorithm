import java.util.*;

class Solution {
    
    static class point{
        int idx,value;
        public point(int idx,int value)
        {
            this.idx=idx;
            this.value=value;
        }
        
    }
    
    public long solution(int[] a2, int[][] edges) {
        // a=new int[]{ -2,1,1};
        // edges=new int[][] {{0,1},{2,1}};
        
        long answer = 0;
        long [] a=new long[a2.length];

        
        
        Queue<Integer> q=new LinkedList<>();
        
        int sum=0;
        int idx=0;
        
        ArrayList<Integer> []map=new ArrayList[a.length];
        
        for(int i=0;i<a.length;i++)
        {
            map[i]=new ArrayList<>();
            a[i]=a2[i];
        }
        
        int []indegree=new int[a.length];
        
        for(int v:a2)
        {
            sum+=v;
            idx++;
        }
        
        for(int []v:edges)
        {
            indegree[v[0]]+=1;
            indegree[v[1]]+=1;  //차수
            map[v[0]].add(v[1]);
            map[v[1]].add(v[0]);
        }
        
        for(int i=1; i<a.length; i++){
            if(map[i].size()==1) q.add(i);
        }
        
        if(sum==0) //로직구현
        {
            answer=0;
            //차수가 0이될대가지 방문
            while(!q.isEmpty())
            {
                int cur=q.poll();
                
                if(indegree[cur]==0) continue;
                 indegree[cur]--;
                
                int s=map[cur].size();
                
                for(int j=0;j<s;j++)
                {
                    int next=map[cur].get(j);
                    
                    if(indegree[next]==0)continue;
                     
                    indegree[next]--;
                    answer+=Math.abs(a[cur]);
                    // System.out.println("ans"+answer+ " "+a[cur]);
                    a[next]+=a[cur];
                    
                    if(indegree[next]==1 )
                    {
                                            // if(next == 0) continue;
                        q.add(next);
                        
                    }
                }
                
            }
            
            }
        else{
            return -1;
        }
            
         
        return answer;
    }
    
}