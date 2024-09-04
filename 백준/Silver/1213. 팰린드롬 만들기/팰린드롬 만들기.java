import java.io.*;
import java.util.*;
 
public class Main {
   public static void main(String[] args) throws IOException {
       
      // StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());

       
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

           String  str=br.readLine();
        if(str.length()==1){
            System.out.println(str);
            return;
        }

       // AAABB

       char cnt[]=new char [33];
       
       for(int i=0;i< str.length();i++  ){
           char ch=str.charAt(i);
           cnt[ ch-'A']++;
       }

       StringBuilder front=new StringBuilder();
       StringBuilder end=new StringBuilder();
       StringBuilder mid=new StringBuilder();

       
       for(int i=0;i< 33;i++  ){
            int len=cnt[i]/2;
           
            if(cnt[i]>0 && cnt[i]%2==0){
                for(int j=0;j<len;j++){
                    
                    front.append((char)('A'+i) );
                }
            }
            
            else if(cnt[i]>1 && cnt[i]%2==1){ //홀수
                 for(int j=0;j<len;j++){
                    
                    front.append((char)('A'+i) );
                }
               
           }
           
        }
       

       for(int i=32;i>=0;i--  ){
            int len=cnt[i]/2;
            int all=cnt[i];

           if(cnt[i]>0 && cnt[i]%2==0){
                 for(int j=0;j<len;j++){
                    
                end.append((char)('A'+i) );
                }
            }

             else if(cnt[i]>1 && cnt[i]%2==1){ //홀수
                 for(int j=0;j<len;j++){
                    
                    end.append((char)('A'+i) );
                }
               
           }


           
        }
       


       for(int i=32;i>=0;i--  ){
            int len=cnt[i]/2;

           if(cnt[i] %2==1){
                mid.append((char)('A'+i) );
                
            }
           
        }

       
       if(front.toString().equals("")||end.toString().equals("")||mid.toString().length()>1 ){
          System.out.print(   "I'm Sorry Hansoo");
           return;
       }
 
      System.out.print(  front.toString() );
      // System.out.print(   "mm");
       
      System.out.print(   mid.toString() );
      // System.out.print(   "ee");
       
      System.out.println(  end.toString() );

       
       
   }
    
}