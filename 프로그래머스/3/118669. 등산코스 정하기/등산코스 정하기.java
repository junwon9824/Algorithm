import java.util.*;

class Solution {
    static int []g;
    static int []dis;
    static int intensity=Integer.MAX_VALUE;
    static int summitnum;
    static ArrayList<ArrayList<point>> list;
    
    static class point  {
        int  e,w;
        public point( int e,int w)
        {
             this.e=e;
            this.w=w;
        }
         
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
//         n=2;
//         paths=new int[][]{{1, 2, 3}};
//         gates=new int[]{1};
//         summits=new int[]{2};
        int[] answer = new int[2];
        g=new int[gates.length];
        g=Arrays.copyOf(gates,gates.length);
            // System.out.println("gates"+ g[0] );
        
        list=new ArrayList<>();
        dis=new int[n+1];
        
        for(int i=0;i<=n;i++)
        {
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<paths.length;i++)
        {
            
            if( issummit(summits,paths[i][0]) || isgate(gates,paths[i][1]) )               {
                list.get(paths[i][1]).add(new point(paths[i][0],paths[i][2]));
              }
            
           else if(issummit(summits,paths[i][1]) || isgate(gates,paths[i][0]) ){
                list.get(paths[i][0]).add(new point(paths[i][1],paths[i][2]));
      }
            else{
                list.get(paths[i][0]).add(new point(paths[i][1],paths[i][2]));
                list.get(paths[i][1]).add(new point(paths[i][0],paths[i][2]));
            }
            
        }
        dijkstra();
        Arrays.sort(summits);
        
        for(int summit:summits){
            // System.out.println("summit"+dis[summit]);
            if(dis[summit] <intensity ){
                intensity=dis[summit];
                summitnum=summit;
            }
        }
        
        answer[0]=summitnum;
        answer[1]=intensity;
        
        return answer;
    }
    
    static boolean issummit(int []summits,int v){
        for(int summit:summits){
            if(summit==v)
                return true;
        }
        
        return false;
    }   
    
    static boolean isgate(int []gates,int v){
        for(int gate:gates){
            if(gate==v)
                return true;
        }
        return false;
    }   
    
    static void dijkstra(){
        Queue<point> q=new LinkedList<>();
        
        Arrays.fill(dis,Integer.MAX_VALUE);
        
        for(int i=0;i<g.length;i++)
        {
            q.add(new point(g[i] ,0));
            dis[g[i]]=0;
             // System.out.println("disss "+ dis[g[i]]);
        }
        
        while(!q.isEmpty()){
            
            point p=q.poll();
            int e=p.e;
            int w=p.w;

            if(dis[e] <w )
                    continue;
            
            // System.out.println("cur "+e+"w "+w+"diss"+ dis[e] );
            
            for(int i=0;i<list.get(e).size();i++){
                
                point pp=list.get(e).get(i);
                int tmp=Math.max( pp.w,dis[e] ) ;
             // System.out.println("innn"+tmp);

                if(dis[pp.e] > tmp)
                {
                    dis[pp.e]=tmp;
                    q.add(new point( pp.e,tmp ));
                }

            }
            
        }
        
    }
    
}