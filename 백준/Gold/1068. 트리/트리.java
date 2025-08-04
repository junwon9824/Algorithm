import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static    ArrayList<Integer> []list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]); // 단어의 개수
        str = br.readLine().split(" ");
        list=new ArrayList[N];
        
        for(int i=0;i<N;i++){
            list[i]=new ArrayList<>();
        }
        
        int root=0;
        
        for( int i=0;i<N;i++){
            int p= Integer.parseInt(str[i]);
            int parent = p;

            if(parent==-1){
                root=i;
                continue;
            }
            
                list[parent].add(i);  
        }
        
        str = br.readLine().split(" ");
        int del = Integer.parseInt(str[0]);

        // 해당 노드 제거 로직 추가.
        
        System.out.println( leaf(root ,del ) );
    }

    static int leaf(int idx , int del ){

        Queue<Integer> q = new LinkedList<>();
    
        q.add(idx);
        int sum=0;
        // System.out.println("root"+idx);
        while(!q.isEmpty()){
            int v = q.poll();
            boolean flag=false;

            if(del == v) continue;
            
            for( int s: list[v]  ){
                // System.out.println(s+" ");
                q.add(s);    
                if(del == s) continue;
                
                flag=true;
            }

            if(!flag){
                sum ++;
            }
            
        }
        return sum;
        
    }

    
    
}