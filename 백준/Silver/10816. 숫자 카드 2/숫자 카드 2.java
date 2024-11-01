import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상근이가 가진 카드 개수
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cardCount = new HashMap<>();

        // 카드 숫자 입력
        String[] cards = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(cards[i]);
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        // 확인할 카드 개수
        int M = Integer.parseInt(br.readLine());
        String[] queries = br.readLine().split(" ");
        StringBuilder result = new StringBuilder();

        // 각 카드의 개수 출력
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(queries[i]);
            result.append(cardCount.getOrDefault(query, 0)).append(" ");
        }

        // 결과 출력
        System.out.println(result.toString().trim());
    }
}
