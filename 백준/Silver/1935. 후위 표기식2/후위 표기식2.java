import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           
        int n,a;

        n= Integer.parseInt(br.readLine());
        
        String str=br.readLine();

//  5
// ABC*+DE/-
// 1
// 2
// 3
// 4
// 5
        
        int []chs=new int[n];

        Arrays.fill(chs,-1);
        for(int i=0;i<str.length();i++){
            
            char ch=str.charAt(i);
            a=-1;
            
            if(  'A'<=ch && 'Z'>= ch && chs[ch-'A']==-1 ){
                a= Integer.parseInt(br.readLine());
                
            }
            
            if(  'A'<=ch && 'Z'>= ch && a!=-1 ){
                chs[ch-'A']=a;
            }
            
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i< str.length();i++){
            
            char ch=str.charAt(i); 
            
            if(  'A'<=ch && 'Z'>= ch  ){
                
                // chs[ch-'A'] ;
                sb.append( chs[ch-'A'] );
                    
            }
                
            else{
                
                sb.append( ch );
            }
            
        
        }

         Stack<Double> q=new Stack<>();

        for( char ch: str.toCharArray()  ){
            
            // System.out.println(ch+" ddd");
            
            if( ch>='A' && ch<='Z' ){
                q.add( (double) chs[ch-'A'] );
            }
                
            else{ //사칙연산ㅅ
                double i1= q.pop();
                double i2= q.pop();

                // int i1= ((int)c1);
                // int i2=(int)(c2);
                
                if(ch=='*'){
                    q.add(i1*i2  );
                }

                if(ch=='+'){
                    q.add(i1+i2  );
                    
                    // System.out.println(q.toString()+" sss");
                }

                if(ch=='-'){
                    q.add(i2-i1  );
                    
                    
                }

                if(ch=='/'){
                    q.add( (double)i2/i1  );

                    
                    
                }

                    // System.out.println(q.toString()+" sss");
                
            }
            
        }

        
        
        System.out.printf("%.2f", q.pop());

	}

}