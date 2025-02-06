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

        for(int i=0;i<n;i++){
              str= br.readLine().split(" ");
            arr[i]= Integer.parseInt(str[0] );
        }

        Arrays.sort(arr);

        
        int tmp= (int) Math.round ( n*0.15);
        int sum=0;
        
        for(int i=tmp;i<n-tmp;i++){
            sum+=arr[i];    
        }
        int div = n-2*tmp;
        int avg= (int)Math.round (sum/(double)(div));
        
        
        // System.out.println("tmp"+tmp);
        // System.out.println ("sum: "+sum);
        // System.out.println ("divide: "+ div);
        System.out.println (avg);



        
    } 



    
}
