 

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main  {

// 만약 해당 값이
	static StringBuilder sb;
	static int res = Integer.MAX_VALUE;
	static char[][] ch; 

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());
        String str= br.readLine();
        Queue<Character> q=new LinkedList<>();

        boolean flag=false;
        int min=Integer.MAX_VALUE;
        int cnt=0;
        
        //오른쪽으로 빨강이동
        for(int i=n-1;i>=0;i--){
            if(flag&&str.charAt(i)=='R'){
                cnt++;                
            }   
            else if( str.charAt(i)=='B'){
                flag=true;
            }
        }
        min=Math.min(min,cnt );

        
        //왼쪽으로 빨강이동
        
        flag=false;
        cnt=0;
        
         for(int i=0;i<n;i++){
            if(flag&&str.charAt(i)=='R'){
                cnt++;                
            }   
            else if( str.charAt(i)=='B'){
                flag=true;
            }
        }
        min=Math.min(min,cnt );

        
     //오른쪽으로 파랑이동
      flag=false;
        cnt=0;
        
        for(int i=n-1;i>=0;i--){
            if(flag&&str.charAt(i)=='B'){
                cnt++;                
            }   
            else if( str.charAt(i)=='R'){
                flag=true;
            }
        }
        min=Math.min(min,cnt );



        
     //왼쪽으로 파랑이동
        flag=false;
        cnt=0;
        
         for(int i=0;i<n;i++){
            if(flag&&str.charAt(i)=='B'){
                cnt++;                
            }   
            else if( str.charAt(i)=='R'){
                flag=true;
            }
        }
        min=Math.min(min,cnt );
             

		System.out.println(min);

        
	} 
  

}
