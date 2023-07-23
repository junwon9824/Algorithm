 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class  Main  {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		long sum = 0;
		sum = a * b * c;

		String str = String.valueOf(sum);
		int[] cnt = new int[10];

		for (int i = 0; i < str.length(); i++) {
			int v = str.charAt(i) - '0';
			cnt[v]++;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}

	}

}
