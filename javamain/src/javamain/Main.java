package javamain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer; 
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.abs;
public class Main {
	static FastScanner in = new FastScanner();
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) {
		
		//////////////////////////////////////////////
		int t;
		t = in.nextInt();
		for (int i = 1; i <= t; i++) {
			solve(t);
		} 
		//////////////////////////////////////////////
		out.close();
	}
	
	
	private static void solve(int t) {
		int n = in.nextInt();
		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}
		
		if (sum % 4 == 0) {
			for (int i = 1; i < n - 1; i++) {
				int ops = arr[i]/2;
				ops = min(arr[i-1], ops);
				arr[i] -= ops * 2;
				arr[i-1] -= ops;
				arr[i+1] -=ops;
			}
//			for(int x: arr) {
//				out.print(x+" ");
//			 }

			boolean flag = true;
			for (int x : arr) {
				if (x != 0) {
					flag = !flag;
					break;
				}
			}
			if (flag) {
				out.println("Yes");
			} else {
				out.println("No");
			}

		} else {
			out.println("No");
		}
		
	}
	


	static final int mod = 1_000_000_007;
	
	static ArrayList<Integer> Sieve(int N) {
        ArrayList<Integer> primes = new ArrayList<>();
        if (N <= 1) {
            return primes;
        }
        // 0 means true/ prime; 1 means not prime;
        int[] markArray = new int[N + 1];
        // making 0, 1 and all even numbers as 1(not prime)
        markArray[0] = 1;
        markArray[1] = 1;
        for (int i = 4; i <= N; i += 2) {
            markArray[i] = 1;
        }
        // adding 2 as a prime number
        primes.add(2);

        int limit = (int) Math.sqrt((double) N) + 1;
        for (int i = 3; i <= N; i += 2) {
            if (markArray[i] == 0) {
                primes.add(i);
            }
            if (i <= limit) {
                for (int j = i * i; j <= N; j += i * 2) {
                    markArray[j] = 1;
                }
            }
        }
        return primes;
    }
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
 
		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
}


///Eclipse setup
// set these templates
// Preference -> Editor -> templates -> sout -> out.println(${cursor});
// Preference -> Editor -> templates -> pout -> out.print(${cursor});

/** Preference -> Editor -> templates -> mtest
 * 	int t;
	t = in.nextInt();
	for(int i =1;i<=t;i++) {
		solve(t);
	}
 * 
 * 
 * **/


