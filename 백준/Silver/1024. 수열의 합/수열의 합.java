import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        
        for (int len = L; len <= 100; len++) {
            
            int temp = N - len * (len + 1) / 2 + len ; // L 개 연속한 것이라 가정 하고, 제일 최소가 1부터 시작한 len 개 연속한 덩어리.
            
            // System.out.println(len+" ttt "+temp);

            if(temp<0 ){ // 음수가 되는게 말이 안된다. 최소값을 뺏는데 음수면 아예 있을수가 없음..
                System.out.println(-1);
                return;
            }
            
            if (temp % len == 0) {
                int start = temp / len ; //0 에서부터 시작한 n 개 연속한 덩어리가 움직인 것. 시작점.  
                // System.out.println(len+" ttt "+temp+" "+start);
                
                    
                    for (int i = 0; i < len; i++) {
                        System.out.print(start + i + " ");
                    }
                    
                    System.out.println();
                    return;
                
                // }
                
            }
            
            
        }
        
        System.out.println(-1);
    }
}
