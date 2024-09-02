import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str =   br.readLine().split(" " );
            
          int []word= new int[5];

        for(int i=0;i<5;i++)
            word[i]=Integer.parseInt(str[i]) ;
        
        int n=3;
        
        while( true){
            int cnt=0;
            
            for(int i=0;i<5;i++ ){
                if( n%word[i] ==0)
                    cnt++;
                
            }
            
            if(cnt>=3){
                
                System.out.println(n);
                break;
            }
                
            n++;
        }
 
    }
}