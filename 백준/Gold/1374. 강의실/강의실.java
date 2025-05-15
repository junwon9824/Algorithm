import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int []> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            list.add(new int[]{a, b, c});
        }

        // 시작 시간 기준 정렬
        list.sort((a, b) -> {
            return a[1] - b[1];
        });

        // 우선순위 큐(최소 힙): 종료 시간 기준
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] lec : list) {
            int start = lec[1];
            int end = lec[2];
            // 가장 빨리 끝나는 강의실이 현재 강의 시작 시간 이전에 끝나면 재사용
            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.add(end);
        }

        // 남아있는 방의 개수가 최소 강의실 수
        System.out.println(pq.size());
    }
}
