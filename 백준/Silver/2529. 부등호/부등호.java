import java.io.*;
import java.util.*;
///백준 2529

public class Main {
      static  int K ;   // 구간 합을 구하는 횟수 

    static boolean [] visit ;
    static ArrayList<String> list=new ArrayList<>();
     static char [] ch;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

          K = Integer.parseInt(st.nextToken());   // 구간 합을 구하는 횟수 

        String []str= br.readLine().split(" ");
        ch=new char[K];
        
        for (int i = 0; i < K; i++) {
            
            ch[i]=str[i].charAt(0);
        }
            
       for (int i = 0; i < K; i++) {
                // System.out.println(ch[i]);
                
        }
 
            visit=new boolean[10];
            
            
            solve( K+1, 0,"" );

            System.out.println(list.get(list.size()-1) );
            System.out.println(list.get(0) );
    }
    
    static void solve(int d , int cur,String str){
        
        // System.out.println("cur"+cur+"str"+str);

        if(d==cur)
        {
            // System.out.println("Lsast");
            list.add(str);
            return;
        }
        
        for(int i=0;i<=9;i++){

            if(visit[i])continue;
            
           // if( cur!=0  )
           //  System.out.println("cur"+cur+"i"+i+" (int)str.charAt(cur-1)"+ (int)(str.charAt(cur-1)-'0') );
                
           if( cur==0  ){
                visit[i]=true;
                // System.out.println("plus i"+i+"Cur"+cur);
               
                solve(d, cur+1,str+i);
                visit[i]=false;
               
                
            }
                
            else if( ch[cur-1] =='>' && (int)(str.charAt(cur-1)-'0')   >i  ){
                visit[i]=true;
                // System.out.println(">>>"+cur);
                
                solve(d, cur+1,str+i);
                visit[i]=false;
                
            }
                
            else if( ch[cur-1] =='<' &&  (int)(str.charAt(cur-1)-'0') <i    ){
                
                visit[i]=true;
                // System.out.println("<<<"+cur);
                
                solve(d, cur+1,str+i);
                visit[i]=false;
                
            }
            
           
            
        }
        
    }
 
}