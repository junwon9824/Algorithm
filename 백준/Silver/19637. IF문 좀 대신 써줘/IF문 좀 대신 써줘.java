import java.util.*;
import java.io.*;

public class Main {

    static class point{
        int power;
        String status;
        
          point(String status,int power){
            this.power=power;
            this.status=status;
            
        }
    }
     static   ArrayList<point> list=new ArrayList<>();
    
    static int search(int su ){
        int left=  0;
        int right=  list.size()-1;
        
        while(left<= right){
            
            int mid=(left+right)/2 ;
            
            if( su <= list.get(mid).power  ){
        // System.out.println( "rrr");
                
                right=mid-1;
                
            }
                
            else{
                left= mid+1;
        // System.out.println( "lllllllllll");
                
            }
        // System.out.println(su+ " "+left+" "+right+" " +mid);
            
        }
        
     return left;   
    } 
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String []str =  br.readLine(). split (" ");
           int  N = Integer.parseInt ( str[0]);
           int  M = Integer.parseInt ( str[1]);
        String [] name = new String [ N];
            
        for(int i=0;i<N;i++){
                String []str2 =  br.readLine(). split (" ");
                list.add(new point(str2[0],Integer.parseInt(  str2[1] )  ) );
                name[i]=str2[0];
                
        }
        StringBuilder sb=new StringBuilder();
        
            for(int i=0;i<M;i++){
                String []str2 = br.readLine().split(" ");
                int su=Integer.parseInt(str2[0]);
                
               int idx= search( su);
            sb.append(list.get(idx).status ).append("\n");

            }
        
                    System.out.println(sb.toString() );

    }


    
}
