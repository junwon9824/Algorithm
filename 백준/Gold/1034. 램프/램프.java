import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에서 N (행의 개수)과 M (열의 개수)을 읽습니다.
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // 각 행의 램프 상태를 저장할 배열과, 각 행 패턴의 등장 횟수를 저장할 HashMap을 선언합니다.
        String[] lamps = new String[N];
        Map<String, Integer> rowPatternCounts = new HashMap<>();

        // N개의 줄에 걸쳐 램프 상태를 읽고, 각 패턴의 등장 횟수를 HashMap에 기록합니다.
        for (int i = 0; i < N; i++) {
            lamps[i] = br.readLine();
            rowPatternCounts.put(lamps[i], rowPatternCounts.getOrDefault(lamps[i], 0) + 1);
        }

        // 마지막 줄에서 K (스위치 조작 횟수)를 읽습니다.
        int K = Integer.parseInt(br.readLine());

        int maxLitRows = 0; // 최대로 켜진 행의 개수를 저장할 변수

        // HashMap에 저장된 각 고유한 행 패턴에 대해 반복합니다.
        for (Map.Entry<String, Integer> entry : rowPatternCounts.entrySet()) {
            String pattern = entry.getKey();
            int countOfSamePattern = entry.getValue();

            int zeroCount = 0; // 현재 패턴에서 '0' (꺼진 램프)의 개수를 셉니다.
            for (char c : pattern.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                }
            }

            // 램프를 모두 켜기 위한 조건 확인:
            // 1. 꺼진 램프의 개수 (zeroCount)가 K보다 작거나 같아야 합니다.
            //    (K번의 조작으로 모든 0을 1로 바꿀 수 있어야 하므로)
            // 2. (K - zeroCount)가 짝수여야 합니다.
            //    (스위치를 짝수 번 누르면 램프 상태가 원래대로 돌아오므로,
            //     0을 1로 바꾼 후 남은 조작 횟수가 짝수여야 최종적으로 1 상태를 유지할 수 있습니다.)
            
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                // 이 조건을 만족하는 패턴이라면, 해당 패턴과 동일한 모든 행들이 켜질 수 있습니다.
                // 따라서 현재 maxLitRows와 비교하여 더 큰 값으로 업데이트합니다.
                maxLitRows = Math.max(maxLitRows, countOfSamePattern);
            }
            
        }

        // 최종적으로 최대로 켤 수 있는 행의 개수를 출력합니다.
        System.out.println(maxLitRows);

    }
}