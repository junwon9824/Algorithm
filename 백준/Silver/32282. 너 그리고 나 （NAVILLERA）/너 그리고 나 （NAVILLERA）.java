import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 


        String [] str=br.readLine().split(" ");
        // 입력 받기
        
        int X = Integer.parseInt(str[0]);
        int Y = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);

        double  dis=  getdis( X,Y);
        
        // System.out.println(dis+" "+dis%c );

        double res= dis%c==0? dis/c: dis/c+1;

        
        if(dis<c){
          res= 2;
            
        }
        
        if(dis==0){
            res=0;
        }
        
        // 결과 출력
        System.out.println((int)res );
        
    }
    
    static double getdis(int a,int b){

        double sum = Math.sqrt( Math.pow( a,2) + Math.pow( b,2) );
        
        return sum;
    }
 
}
