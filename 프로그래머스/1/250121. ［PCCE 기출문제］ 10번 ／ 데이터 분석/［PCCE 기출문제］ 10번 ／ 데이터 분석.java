import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int[][] answer = {};
        String[] columns = {"code", "date", "maximum", "remain"};
        
        int sortByIndex = Arrays.asList(columns).indexOf(sort_by);
        int extIndex = Arrays.asList(columns).indexOf(ext);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->  a[sortByIndex]- b[sortByIndex]);

        // 조건에 맞는 데이터 필터링 후 PriorityQueue에 추가
        for (int[] v : data) {
            if (v[extIndex] < val_ext) {
                pq.add(v);
            }
        }

        answer = new int[pq.size()][4];
        int index = 0;

        // PriorityQueue에서 데이터를 꺼내어 배열에 저장
        while (!pq.isEmpty()) {
            answer[index++] = pq.poll();
        }
        
//         for(int []v:pq){
//             answer[index++] = v;
            
//         }

        return answer;
    }
}
