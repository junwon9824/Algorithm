 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	static long[] arr;
	static int n;
	static int k;

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		int sum = 0;
		arr = new long[k];

		long max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}

//		System.out.println("arr" + Arrays.toString(arr));
		solve(1, max);

	}

	static void solve(long left, long right) {

		long mid = 0;
		long res = 0;

		while (left <= right) {

			mid = (left + right) / 2;
//			System.out.println("left right mid " + left + " " + right + " " + mid);

			long size = countlen(mid);

//			System.out.println("size" + size);

			if (size < n) {
				right = mid - 1;
			}

			else if (size >= n) {
				res = mid;
				left = mid + 1;
			}

		}

		System.out.println(res);
	}

	static long countlen(long len) {
		long cnt = 0;

		for (int i = 0; i < arr.length; i++) {
			cnt += arr[i] / len;
//			System.out.println(" cnt len" + cnt + " " + len);
		}

		return cnt;
	}

}
