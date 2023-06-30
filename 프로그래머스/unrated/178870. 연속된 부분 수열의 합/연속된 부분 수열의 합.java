import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int sum = 0;
        int end = 0;
        int interval = n+1;

        int[] res = new int[2];

        for (int start = 0; start < n; start++) {
            while (sum < k && end < n) {
                sum += sequence[end];
                end++;
            }
            
            if (sum == k && end - 1 - start < interval) {
                res[0] = start;
                res[1] = end - 1;
                interval = end - 1 - start;
            }
            sum -= sequence[start];
        }

        return res;
    }
}
