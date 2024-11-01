import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            BigInteger N = new BigInteger(br.readLine());
            BigInteger left = BigInteger.ONE; // k의 최소값
            BigInteger right = N; // k의 최대값
            BigInteger result = BigInteger.ZERO;

            while (left.compareTo(right) <= 0) {
                BigInteger mid = left.add(right).divide(BigInteger.TWO); // 징검다리 개수

                // 징검다리 높이의 합 계산
                BigInteger sum = mid.multiply(mid.add(BigInteger.ONE)).divide(BigInteger.TWO);

                // x의 최대값 계산
                if (sum.compareTo(N) <= 0) {
                    result = mid; // 현재 mid를 최댓값으로 업데이트
                    left = mid.add(BigInteger.ONE); // 더 큰 k를 탐색
                } else {
                    right = mid.subtract(BigInteger.ONE); // k를 줄임
                }
            }

            System.out.println(result);
        }
    }
}
