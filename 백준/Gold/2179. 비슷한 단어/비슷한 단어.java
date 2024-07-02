import java.io.*;
import java.util.*; 


public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); 
        StringBuilder sb=new StringBuilder();
        
         int n=Integer.parseInt(str);
        String []str2 = new String[n];

        int max=-1;
        
        for(int i=0;i<n;i++){
              str2[i] = br.readLine(); 
            
        }
        
       // System.out.println(str2.length);
        String s="";
        String t="";
        
        for(int i=0;i<n;i++){
            String tmp=str2[i];  
            
            for(int j=i+1;j<n;j++){
                String tmp2=str2[j];  
                int cnt=0;
               // System.out.println(tmp);
                
                int size=Math.min(tmp.length(),tmp2.length());
                
                for(int k=0;k<size;k++){
                    if(tmp.charAt(k)==tmp2.charAt(k) ){
                      

                        
                        cnt++;
                    }
                    else
                        break;
                }
                if(max<cnt){
                    max=cnt;
                      s=tmp;
                      t=tmp2;
                }
                    
            }
        }

                    sb.append(s).append('\n').append(t);
        
        
       System.out.println(sb.toString());
        
    }
     
}
