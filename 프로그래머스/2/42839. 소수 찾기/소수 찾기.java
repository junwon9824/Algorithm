import java.util.*;
class Solution {
    static int num=0;
    static String numbers2;
    static boolean [] visit;
    static HashSet<Integer> hs =new HashSet<>();
    
    public int solution(String numbers) {
        // numbers="143";
        int answer = 0;
        int d=numbers.length();
        numbers2=numbers;
        visit=new boolean[d];
        
        solve( d,0,new StringBuilder() );
        answer=hs.size();
        
        return answer;
    }
    
    static void solve(int d,int cur,StringBuilder str){
        
        if(cur==d ){
            
            if(!str.toString().equals("")&& sosu(Integer.valueOf(str.toString())) ){
                // num++;
                hs.add(Integer.valueOf(str.toString()));
                System.out.println(str.toString());
            }
            return;
        }
        
        for(int i=0;i<d ;i++)
        {
            if(visit[i]==false){
                 visit[i]=true;
                solve(d,cur+1,new StringBuilder(str).append(numbers2.charAt(i)));
                visit[i]=false;
                
            }
        }
        
        solve(d,cur+1,str);

    }
    
    static boolean sosu(int v){
        
        if(v<2){
            return false;
        }
        
        
        for(int i=2;i*i<=v ;i++)
        {
            if(v%i==0)
            {
                return false;
            }
        }
        
        return true;
        
    }
    
}