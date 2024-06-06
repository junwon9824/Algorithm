import java.util.*;

class Solution {
    static String [] Words;
    static String Target;
    static boolean [] visit;
    static int answer = 0;
    
    static Queue<String [] > q=new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        visit=new boolean[words.length];
        Target=target;
        Words=words;
        
        solve(0,begin);
        return answer;
        
    }
    
    static boolean same(String a,String b){
        int cnt=0;
        
        for(int i=0;i< a.length();i++){
            if(a.charAt(i)==b.charAt(i)){
                cnt++;
            }
        }
        
       return cnt==a.length()-1;
        
    }
    
   static void solve(int d,String cur){
       
        q.add(new String[]{cur , String.valueOf("0") });
        
        while(!q.isEmpty()){
            
            String []str=q.poll();
            // System.out.println(str[0]+" "+Target);
            String curr=str[0];
            
             if(curr.equals( Target)) {
                answer=Integer.valueOf(str[1]);
                return;
            }
            
            int idx=0;
            
            for(String s:Words)
            {
                if(!visit[idx] && same(s ,str[0] ) ){
                    visit[idx]=true;
                    q.add(new String[] { s,String.valueOf(Integer.valueOf(str[1])+1) } );
                }
                idx++;
            }

        }
    }
    
}