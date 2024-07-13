import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 성냥개비 개수에 따른 최소 숫자 초기화
        long[] minDp = new long[101];
        Arrays.fill(minDp, Long.MAX_VALUE);
        
        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        minDp[8] = 10; //인덱스가 개수 

        String[] add = {"1", "7", "4", "2", "0", "8"}; // 2 3 4 5 6 7 성냥개비로 만들 수 있는 최소 숫자

        // 동적 계획법을 통해 최소 숫자 계산
        for (int j = 9; j <= 100; j++) {
            for (int k = 2; k <= 7; k++) { // 2부터 7까지의 성냥개비 사용
                String candidate = minDp[j - k] + add[k - 2];
                
                minDp[j] = Math.min(Long.parseLong(candidate), minDp[j]);
                
                // minDp[j] =  Long.parseLong(candidate);
            }
        }

        for (int i = 0; i < n; i++) {
            int matchesCount = Integer.parseInt(br.readLine());

            // 최대 숫자 계산
            StringBuilder max = new StringBuilder();
            long a = matchesCount / 2;
            long b = matchesCount % 2;

            if (b == 1) {
                max.append("7");
                a--; // 7을 추가했으므로 1을 빼줌
            }

            for (int j = 0; j < a; j++) {
                max.append("1");
            }

            System.out.println(minDp[matchesCount] + " " + max.toString());
        }
        
    }
}
