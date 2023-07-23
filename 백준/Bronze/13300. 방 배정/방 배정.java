 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] cnt = new int[2][6];

		out: for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cnt[s][y - 1]++;

		}
		int size = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				size += cnt[i][j] / k + (cnt[i][j] % k == 0 ? 0 : 1);
			}

		}

		System.out.println(size);
	}

}
