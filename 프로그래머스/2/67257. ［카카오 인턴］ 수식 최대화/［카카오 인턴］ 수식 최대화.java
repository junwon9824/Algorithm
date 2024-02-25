import java.util.*;

class Solution {
    // static char []priority ={'+','-','*'}; 
    
    static boolean []visit;
    static HashSet<Character> set=new HashSet<>();
    static ArrayList<Character> prioritylist=new ArrayList<>();
    static ArrayList<Character> opt ;
      static  long tmp=0;
    
    private static Long calc(long a, long b, char opt) {
        long res = 0;
        if (opt == '+') {
            res = a + b;
        } else if (opt == '-') {
            res = a - b;
        } else {
            res = a * b;
        }
        return res;
    }
    
      static void setorder(int idx){
          
          if(set.size()== idx)
          {
              solve();
              
          }
          
          for(int i=0;i<set.size();i++){
              
              if (visit[i]) continue;
              visit[i] = true;
              
              prioritylist.add(opt.get(i) );
              setorder(idx+1);
              prioritylist.remove(prioritylist.size()-1);
              
              visit[i] = false;
          }
          
      }
    
    static void solve(){
        //순위 주어졋으니 이를 토대로 계산.
        
        // calc(a,b,opt);
        
        ArrayList <Long> tmpnum=new ArrayList<>(list);
        ArrayList <Character> tmpop=new ArrayList<>(op);
        
        // System.out.println("tmpnum"+tmpnum.toString());
        // System.out.println("tmpop"+tmpop.toString());
        // System.out.println("prioritylist"+prioritylist.toString());
        
        for(char ch: prioritylist)
        {
            for(int i=0;i< tmpop.size();i++)
            {
                // 1+2-3
                if(tmpop.get(i)==ch  ){
                    tmpnum.set(i,calc(tmpnum.get(i) , tmpnum.get(i+1),tmpop.get(i)));
        // System.out.println("res"+ tmpop.get(i)+" "+tmpnum.get(i) );
                    
                    tmpnum.remove(i+1);
                    tmpop.remove(i);
                    i--;
                }

            }
        }
        
        tmp=Math.abs(tmpnum.get(0));
        
        if(tmp>answer)
        {
            answer=tmp;
            
        }
        
    }
    
      static  long answer = 0;
     static   ArrayList<Long> list=new ArrayList<>();
      static  ArrayList<Character> op=new ArrayList<>();
    
    public long solution(String expression) {
        
        int s=0;
        int idx=0;
        
        for(char ch :expression.toCharArray() )
        {
            if(ch=='-'||ch=='*'|ch=='+')
            {
                set.add(ch);
                list.add(Long.parseLong(expression.substring(s,idx)));
                op.add(ch);
                s=idx+1;

            }
            
            idx++;
        }
        
        list.add(Long.parseLong(expression.substring(s)));
        
        opt=new ArrayList<>(set);
        
        visit=new boolean[set.size()];
        setorder(0);
        
        return answer;
    }
    
}