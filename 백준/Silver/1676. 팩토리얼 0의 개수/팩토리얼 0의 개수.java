import java.util.*;
import java.io.*;

public class Main {
     
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []str= br.readLine().split(" ");

        int n=Integer.parseInt(str[0]);

        int five=0;
        int two=0;
        
        for(int i=1;i<=n;i++)
        {
            int tmp=i;

            while(tmp>=2){
                if(tmp%2!=0)
                    break;
                // System.out.println(tmp);
                two++;        
                
                tmp=tmp/2;
                
            }

            tmp=i;
            while(tmp>=5){
                if(tmp%5!=0)
                    break;
                // System.out.println(tmp);
                five++;        
                
                tmp=tmp/5;
                
            }
        
        }
        
        System.out.println(Math.min(five,two));
        
        
    } 
 

    
}
