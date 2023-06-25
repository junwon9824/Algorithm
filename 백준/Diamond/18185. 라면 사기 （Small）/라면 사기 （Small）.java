 
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] v = new int[n + 3];
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			v[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {

			if (v[i + 1] > v[i + 2]) {

				int a = Math.min(v[i], v[i + 1] - v[i + 2]);
				ans += 5 * a;
				v[i] -= a;
				v[i + 1] -= a;

				int b = Math.min(v[i], Math.max(v[i + 2], v[i + 1] - v[i + 2]));
				ans += 7 * b;
				v[i] -= b;
				v[i + 1] -= b;
				v[i + 2] -= b;

			}

			else {
				int b = Math.min(v[i], Math.min(v[i + 1], v[i + 2]));
				ans += 7 * b;
				v[i] -= b;
				v[i + 1] -= b;
				v[i + 2] -= b;

				int a = Math.min(v[i], v[i + 1]);
				ans += 5 * a;
				v[i] -= a;
				v[i + 1] -= a;
			}

			ans += 3 * v[i];

		}

		System.out.println(ans);
	}
}
