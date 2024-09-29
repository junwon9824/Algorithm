import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
        static int cnt=0;
        // static long n,m,k,x,y,w,s,e;
        
    public static void main(String[] args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String [] str=br.readLine().split(" ");
        
        int n,l;
        n=Integer.parseInt(str[0]);
        l=Integer.parseInt(str[1]);

        int cnt=0;

        ArrayList<int []> list=new ArrayList<>();
        int s,e;
        for(int i=0;i<n;i++){
          str=br.readLine().split(" ");
            // s=Long.parseLong(str[0]);
            // e=Long.parseLong(str[1]);
            s=Integer.parseInt(str[0]);
            e=Integer.parseInt(str[1]);
            //웅덩이
            
            list.add(new int[]{s,e});
        }
        
        list.sort(  (a,b)->{
            return b[1]-a[1];
            // Integer.compare(b[1],a[1]);
        });
        
        int size =list.size();

        //l 널판지길이
        int last=Integer.MAX_VALUE;
        
        for(int i=0 ; i<size  ;i++ ){
            
            int []v=list.get(i);
            
            v[1]=Math.min(v[1],last );
            int tmp= (v[1]-v[0])/l+1;
            
            if((v[1]-v[0])<0){
                
            }
                
            else if((v[1]-v[0])%l==0 ){
                cnt+= (v[1]-v[0])/l;
            }
                
            else
            {
                cnt+= (v[1]-v[0])/l+1;
                last= v[1]-(l* tmp );
            }
            
            // System.out.println( i+" "+cnt+" "+last + " "+ v[1] + " " + l* tmp );
            
        }
        
        System.out.println( cnt );
        
    }
     
 
}