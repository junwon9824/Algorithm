import java.util.*;
import java.io.*;

public class Main {
 
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
            String []str =  br.readLine(). split (" ");

        int N=Integer.parseInt(str[0]);
        int M=Integer.parseInt(str[1]);
        HashMap<String,Integer> hm=new HashMap<>();

        for(int i=0;i<N;i++)
            {
                String str2 =  br.readLine();
                hm.put(str2, 1);
            }

        HashSet<String> hs=new HashSet<>();
        
        for(int i=0;i<M;i++)
            {
                
                String []str2 =  br.readLine().split("[,]");
                for(String st:str2){
                    if(hm.containsKey(st)&&hm.get(st)!=0){
                        hm.remove(st);
                    }
                    
                }
                sb.append(hm.size()).append('\n');
            }

        
                    System.out.println(sb.toString() );

    }


    
}
