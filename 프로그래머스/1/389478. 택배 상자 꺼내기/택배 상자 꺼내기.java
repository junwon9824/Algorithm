class Solution {
    public int solution(int n, int w, int num) {
        
        int layer = (num - 1) / w;
            
        int idx = (num - 1) % w;

        // num의 실제 열 위치 구하기 (지그재그 형태 반영)
        int col;
        System.out.println(idx);
        
        if (layer % 2 == 0) {
            col = idx;
        } else {
            col = w - 1 - idx;
        }

        int count = 0;
        
         int h = (n + w - 1) / w; // 전체 층 수

        // 위층부터 아래층까지 같은 열에 있는 상자 세기
        for (int i = layer; i < h; i++) {
            int boxNum;
            if (i % 2 == 0) {
                boxNum = i * w + col + 1;
            } else {
                boxNum = i * w + (w - 1 - col) + 1;
            }

            if (boxNum <= n) count++;
        }

        return count;
    }
}
