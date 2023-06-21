 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[N];

		String str = br.readLine();
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'P') {

				int s = Math.max(i - K, 0);
				int e = Math.min(i + K, str.length() - 1);

				for (int j = s; j <= e; j++) {

					if (str.charAt(j) == 'H' && visit[j] == false) {

						visit[j] = true;
						cnt++;
						break;
					}

				}
			}
		}

		System.out.println(cnt);

	}

}