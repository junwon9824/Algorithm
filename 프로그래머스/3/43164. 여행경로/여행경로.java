import java.util.*;

class Solution {
    
        static int rsize=0;
        static int csize=0 ;
        static String [][]Tickets;
        static String[] answer ;
        static boolean[] visit ;
        static ArrayList<String > list;
    
    public String[] solution(String[][] tickets) {
         list=new ArrayList<>();
          rsize=tickets.length;
          csize=tickets[0].length;
        visit =new boolean[rsize];
        
        Tickets=new String[rsize][csize];
        
        Tickets=tickets;
        
//         for(int i=0;i<rsize;i++)
//         {
//             Arrays
//         }
        
        HashSet<String> hs=new HashSet<>();
        
        for(String []v : tickets){
            hs.add(v[0]);
            hs.add(v[1]);
        }
        
        // System.out.println(rsize+1 );
        
        answer=new String[ rsize+1 ];
        
        String str=null;
        
        solve( 0 ,"ICN","ICN");
        
        Collections.sort(list);
        answer=list.get(0).split(" ");
        
        return answer;
    }
    
    static void solve(int d,String ans,String cur ){
        
        if(d==rsize ){
            list.add(ans);
            return;
        }
        
        for(int i=0 ;i<rsize ;i++)
        {
            if(Tickets[i][0].equals(cur)&&!visit[i] )
            {
                visit[i]=true;
            // System.out.println(cur+" ticket"+Tickets[i][1]+"   "+ans+" "+d);
                
                solve(d+1, ans+" "+ Tickets[i][1] ,Tickets[i][1] );
                visit[i]=false;

            }
        }
        
    }

    
    
}