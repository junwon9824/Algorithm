 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, d, k, c;
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int s = 0;
		int e = k - 1;

		int ans = 0;
		HashMap<Integer, Integer> set = new HashMap();
		for (int j = 0; j < k; j++) {
			set.put(arr[(j) % n], set.getOrDefault(arr[(j) % n], 0) + 1);
		}

		set.put(c, set.getOrDefault(c, 0) + 1);

		ans = Math.max(ans, set.size());

		for (int i = 0; i < n; i++) {

			set.put(arr[s % n], set.getOrDefault(arr[s % n], 0) - 1);
			if (set.get(arr[s % n]) == 0)
				set.remove(arr[s % n]);
			s++;
			e++;
			set.put(arr[(e) % n], set.getOrDefault(arr[(e) % n], 0) + 1);

			ans = Math.max(ans, set.size());
		}

		System.out.println(ans);

	}

}
