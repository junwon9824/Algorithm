import java.util.*;
import java.io.*;

public class Main {
    
     static ArrayList<Integer> list=new ArrayList<>();
     static ArrayList<ArrayList<Integer> > list2 =new ArrayList<>();
     static ArrayList<Integer> res=new ArrayList<>();
    static int n=0;
    static int m=0;
    static boolean [] visit ;
     static HashSet<  ArrayList<Integer>> hs=new HashSet<>();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []str= br.readLine().split(" ");

          n=Integer.parseInt(str[0]);
          m=Integer.parseInt(str[1]);

        visit = new boolean[n];

        
        int []arr= new int[n];
          str= br.readLine().split(" ");

        for(int i=0;i<n;i++){

            arr[i]= Integer.parseInt(str[i] );
            list.add(arr[i]);
            
        }
       
         

        Collections.sort(list);

        solve(0,0  );
  

         
        // System.out.print(hs.size() );

        for( ArrayList<Integer> tmp : hs ){
            // System.out.print(tmp );
            
            list2.add( tmp  );
        }

        
        // 정렬
        Collections.sort(list2, (a, b) -> {

            for(int i=0;i<a.size() ;i++){

                if (a.get(i) != b.get(i)) {
                    return a.get(i) - b.get(i);
                }  
            }
            
            int s=a.size();
            
            return a.get(s-1) -b.get(s-1) ;

        });

        for( ArrayList<Integer> v: list2)
        {
            for(int  v1: v)
                System.out.print(v1+" " );
            
            System.out.println(  );
            
        }
        
    } 

    static void solve(int d,int idx){

        if(d == m)
        {
                // System.out.println(res+" res" );
            
                hs.add(new ArrayList<>(res) );
        }
        

        for(int i= 0 ; i< list.size() ; i++)
        {
            if(visit[i])continue;
            int tmp = list.get(i);
             visit[i]=true;
            res.add(tmp);
            solve(d+1, i+1 );
            visit[i]=false;
            res.remove(res.size()-1);
            
        }
        
        
    }

    
}
