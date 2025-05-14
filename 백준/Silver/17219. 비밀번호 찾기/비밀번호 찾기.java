import java.io.*;
import java.util.*;

//17219
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []str = br.readLine().split(" ");

        // System.out.println(str[0]);
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        
        HashMap<String,String> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            String []tmp = br.readLine().split(" ");
            map.put(tmp[0],tmp[1]);
            
        }

         for(int i=0;i<m;i++){
            String tmp = br.readLine();
             
            System.out.println(map.get(tmp) );
            
        }

 
    
    }
}
