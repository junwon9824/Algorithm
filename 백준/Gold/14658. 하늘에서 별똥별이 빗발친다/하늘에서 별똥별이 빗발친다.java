import java.io.*;
import java.util.*;

public class Main {
    static int n = 0;
    static int m = 0;
    static int l = 0;
    static int k = 0;
      static  ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");
        n = Integer.parseInt(words[0]);
        m = Integer.parseInt(words[1]);
        l = Integer.parseInt(words[2]);
        k = Integer.parseInt(words[3]);


        for (int i = 0; i < k; i++) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            list.add(new int[]{a, b});
        }

        int max = 0;

        // 트램펄린의 네 모서리를 모두 고려
        for (int[] v : list) {
            for (int[] v2 : list) {
                
                // 각 모서리를 기준으로 체크
                // 왼쪽 아래 모서리
                max = Math.max(max, countPoints(v[0], v2[1]  ));
                // 왼쪽 위 모서리
                max = Math.max(max, countPoints(v[0] - l, v2[1]  ));
                
                // 오른쪽 아래 모서리
                max = Math.max(max, countPoints(v[0]  , v2[1] - l  ));
                
                // 오른쪽 위 모서리
                max = Math.max(max, countPoints(v[0]-l , v2[1] - l  ));
            }
            
        }

        System.out.println(k - max);
    }

    static int countPoints(int x, int y  ) {
        
        int cnt = 0;
        for (int[] point : list) {
            if (point[0] >= x && point[0] <= x + l && point[1] >= y && point[1] <= y + l) {
                cnt++;
            }
        }
        
        return cnt;
        
    }
    
    
}
