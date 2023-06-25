 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] v = new int[n];
		int ans = 0;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		int s = 0;
		int e = 0;

		int[] cnt = new int[100001];

		while (e < n && s < n) {

			while (e < n  && cnt[v[e]] + 1 <= k) {
				cnt[v[e]]++;
				e++;
			}
			ans = Math.max(ans, e - s);
			cnt[v[s]]--;
			s++;

		}

		System.out.println(ans);
	}
}
