import java.util.*;
import java.io.*;

public class Main {
    
     static ArrayList<Integer> list=new ArrayList<>();
    static int n=0;
    static boolean [] visit ;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []str= br.readLine().split(" ");

          n=Integer.parseInt(str[0]);
          

        visit = new boolean[n+1];

        
        int []arr= new int[n];
          str= br.readLine().split(" ");

        for(int i=0;i<n;i++){
            
            arr[i]= Integer.parseInt(str[i] );
        }

        Stack<Integer> st =new Stack<>();
        st.add(1000000);
        
        for(int i=1;i<=n;i++){

                // if(visit[i]  ){
                //     continue;
                // }
            
             // System.out.println("ii "+i);
            int v = arr[i-1];

            int tmp=i;
            
            while( i != arr[tmp-1] ){

                if(st.peek()==i){
                    st.pop();
                    break;
                }


                if(visit[arr[tmp-1]]  ){
                    tmp++;
                    continue;
                }
                
                // System.out.println("st.peek() "+st.peek());
                // System.out.println("arr[tmp-1] "+arr[tmp-1] );
            
                if( st.peek() > arr[tmp-1])
                {
                    
                    st.add(arr[tmp-1]);
                    visit[arr[tmp-1]]=true;
                    
                }

                else
                 {
                     System.out.println("Sad");
                      return;  
                 }
                tmp++;
            }
            if(i==st.peek()){
               // System.out.println("ipopp"+i);
                st.pop();
            }
            
            visit[i]=true;
        }
        
        System.out.println("Nice");



        
    } 



    
}
