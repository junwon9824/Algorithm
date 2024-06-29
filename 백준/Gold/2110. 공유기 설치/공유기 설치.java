 

import java.io.*;
import java.util.*;

public class Main  {

        static ArrayList<Integer> list;
    static int n,c;
    
	public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        list=new ArrayList<>();
        
        String  []str=br.readLine().split(" ");
          n=Integer.parseInt(str[0]); 
          c=Integer.parseInt(str[1]); 
        
        
        for(int i=0;i<n;i++){
            String  str2=br.readLine();
              list.add(  Integer.parseInt(str2 )); 
        }
        
        list.sort((a,b)-> a-b);
        
        System.out.println(  find() );
        
	}
    
    static int find(){
        int left=1;
        int right= list.get(list.size()-1)-list.get(0) ;

        while(left<=right){
            
            int mid=(left+right)/2; //최소거리
            // System.out.println("left "+left +" right "+right+" "+mid+ " valid "+valid(mid));
            
            if(valid(mid )< c ){
                // System.out.println("inn" );
                
                right=mid-1 ;
            }
            else if(valid(mid )> c ){
                left=mid+1;
            }
            else{
                // System.out.println("midd"+ mid );
                left=mid+1;
                // return mid;
            }
        }
        
        return left-1;
    }
    
    static int valid(int mid){
        int cnt=1;
        int tmp=list.get(0);
        int idx=1;
        
        while(idx<list.size()){
            if(list.get(idx)-tmp>=mid )
            {
                tmp=list.get(idx);
                cnt++;
            }
            
            idx++;
        }

        return cnt;
        
    }
 
     

}
