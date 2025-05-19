import java.io.*;
import java.util.*;

//9375
public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str=br.readLine().split(" ");
        
        int n = Integer.parseInt(str[0]);
        int t = Integer.parseInt(str[1]);

        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        Queue<Integer> list=new LinkedList<>();
        str=br.readLine().split(" ");
        
        for(int i=0;i<n;i++){
            //int m= Integer.parseInt(br.readLine());
              
            if(i<t)
            pq.add(Integer.parseInt(str[i]));
            else{
                list.add( Integer.parseInt(str[i]));
            }
        }

        StringBuilder sb=new StringBuilder();
        
        while(!pq.isEmpty()){
            sb.append(pq.poll()+" ");
        }
        while(!list.isEmpty()){
            sb.append(list.poll()+" ");
        }
        System.out.println(sb.toString().trim());


    }
}
