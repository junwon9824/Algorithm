import java.io.*;

import java.util.ArrayDeque;
import java.util.*;

public class Main {
 
	static boolean[] visit;
	static String str = "";
	static int[] dp; 
	static int[] arr; 
	static long sum = 0;

// 창영이는 4와 7로 이루어진 수를 좋아한다. 창영이가 좋아하는 수 중에 K번째 작은 수를 구해 출력하는 프로그램을 작성하시오.
 
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
        
		int n, m, k;
		String []str= br.readLine().split(" ");

		k = Integer.parseInt(str[0]); 
        k++;

        Stack<Integer> st=new Stack<>();
        
        while( k>0){
            
            int v=k%2;    
            st.add(v);
            k=k/2;
        }
             st.pop();

        while(!st.isEmpty()){
            int v=st.pop();

            if(v==1){
                sb.append(7);
            }
                
            else{
                sb.append(4);
                
            }
        }
        
        System.out.println(sb.toString());
        

        // k  1 2 3   4
        //    4 7 44 47(01) 
  

	}
     

	
	
}
