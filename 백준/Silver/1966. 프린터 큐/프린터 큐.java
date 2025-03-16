import java.io.*;
import java.util.*;

public class Main {

    static int []arr;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        // System.out.println(t+" ttt");
        
        for (int i = 0; i <t; i++) {
            
            String []str=  br.readLine().split(" ");

            int n=Integer.parseInt(str[0]);
            int pos=Integer.parseInt(str[1]);
            
             str=  br.readLine().split(" ");
            arr= new int[n];

            for(int j=0;j<n ;j++){
                 arr[j]= Integer.parseInt(str[j]);
            }
// 3
// 1 0
// 5
// 4 2
// 1 2 3 4
// 6 0
// 1 1 9 1 1 1
            solve( pos, n );
            
        }
        
    }

    static void solve(int pos,int n){
        ArrayList<int [] > q=new ArrayList<>();
        // System.out.println(pos+" "+n);
        
            for(int j=0;j<n ;j++){
                q.add(new int[] {arr[j] , j })  ;
                
            }

        
        int cnt=1;
        
        out:while (!q.isEmpty()) {
            int []v=q.remove(0);
            
             for(int j=0; j<q.size() ;j++){
                if( v[0] < q.get(j)[0] ){
                    q.add(new int[] { v[0] , v[1] })  ;
                    continue out;
                }
                 
             }
            
            if(v[1]== pos ){
                System.out.println( cnt);
                break;
            }      
            cnt++;
        }

        
     
        
// 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
// 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
        
    }

    
}
