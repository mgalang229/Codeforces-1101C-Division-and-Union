import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

/*

Important Test Cases:

Test case #1
1
5
1 1
1 1
2 3
3 4
4 5

ans: 1 1 2 2 2

Test case #2

1
5
1 3
2 5
8 14
11 15
9 13

ans: 1 1 2 2 2

 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] l = new int[n], r = new int[n];
			Integer[] indices = new Integer[n];
			for (int i = 0; i < n; i++) {
				l[i] = fs.nextInt();
				r[i] = fs.nextInt();
				indices[i] = i;
			}
			Arrays.sort(indices, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if (l[o1] == l[o2]) {
						return Integer.compare(r[o1], r[o2]);
					}
					return Integer.compare(l[o1], l[o2]);
				}
			});
			int max = r[indices[0]];
			int[] ans = new int[n];
			ans[indices[0]] = 1;
			boolean change = false;
			for (int i = 1; i < n; i++) {
				if (l[indices[i]] > max || change) {
					ans[indices[i]] = 2;
					if (!change) {
						change = true;
					}
				} else {
					ans[indices[i]] = 1;
					max = Math.max(max, r[indices[i]]);
				}
			}
			if (!change) {
				System.out.println(-1);
				continue;
			}
			for (int x : ans) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
