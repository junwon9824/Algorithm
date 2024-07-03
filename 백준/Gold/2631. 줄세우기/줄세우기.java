    import java.io.*;
    import java.util.*; 
    
    
    public class Main {
        public static void main(String[] args) throws Exception {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine(); 
            StringBuilder sb=new StringBuilder();
            
            int n=Integer.parseInt(str );
            int []su=new int[ n];
            ArrayList<Integer>list=new ArrayList<>();
            int [] dp=new int [n];
            int min=Integer.MAX_VALUE;

            // dp[0]=1;
            
            for(int i=0;i<n;i++){
              str = br.readLine(); 
                su[i]= Integer.parseInt(str);
                
            }

             for(int i=0;i<n;i++){
                 
                int pos=Collections.binarySearch(list, su[i] );                     
                 if(pos<0)
                 {
                     pos=-(pos+1);
                     
                 }

                 if( pos==list.size()){
                     list.add(pos,su[i]);
                 }
                 else{
                     list.set(pos,su[i]);
                 }
            }

            
           System.out.println(n-list.size() );
            
        }
        
       
         
    }
