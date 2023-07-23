 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		out: for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] cnt = new int[30];

			String a = st.nextToken();
			String b = st.nextToken();

			for (char ch : a.toCharArray()) {
				cnt[ch - 'a']++;

			}
			for (char ch : b.toCharArray()) {
				cnt[ch - 'a']--;

			}

			for (int i1 = 0; i1 < 30; i1++) {
				if (cnt[i1] != 0) {
					System.out.println("Impossible");
					continue out;
				}
			}
			System.out.println("Possible");

		}

	}

}
