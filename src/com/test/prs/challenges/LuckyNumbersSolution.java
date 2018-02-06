package com.test.prs.challenges;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class LuckyNumbersSolution implements Runnable {

    // leave empty to read from stdin/stdout
    private static final String TASK_NAME_FOR_IO = "";

    // file names
    private static final String FILE_IN = TASK_NAME_FOR_IO + ".in";
    private static final String FILE_OUT = TASK_NAME_FOR_IO + ".out";

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tokenizer = new StringTokenizer("");

    public static void main(String[] args) {
        new LuckyNumbersSolution().run();
    }

    static int MAX_LEN = 18;
    static int MAX_SUM_SQ = MAX_LEN * 9 * 9 + 1;

    static boolean[] IS_PRIME;
    static int PRIME_COUNT;
    static int[] PRIMES;

    static long[][][][] D_COUNT, D_CACHE;
    static int[][][] DC_MIN, DC_MAX;

    static int[] FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM;
    static int[][] P1_HI, P2_HI;

    static long timePrecalc;

    static {
        long timeStart = System.currentTimeMillis();

        IS_PRIME = new boolean[MAX_SUM_SQ];
        Arrays.fill(IS_PRIME, true);
        IS_PRIME[0] = false;
        IS_PRIME[1] = false;

        PRIME_COUNT = 0;
        for (int i = 2; i < MAX_SUM_SQ; i++)
            if (IS_PRIME[i]) {
                PRIME_COUNT++;
                for (int j = i + i; j < MAX_SUM_SQ; j += i) {
                    IS_PRIME[j] = false;
                }
            }

        PRIMES = new int[PRIME_COUNT];
        for (int i = 2, idx = 0; i < MAX_SUM_SQ; i++)
            if (IS_PRIME[i]) {
                PRIMES[idx++] = i;
            }


        // save memory by smart allocation
        D_COUNT = new long[10][MAX_LEN + 1][][];
        for (int digitHigh = 0; digitHigh <= 9; digitHigh++) {
            long[][][] d = D_COUNT[digitHigh];

            for (int i = 0; i <= MAX_LEN; i++) {
                d[i] = new long[i * 9 + 1][i * 9 * 9 + 1];
            }

            // run dp
            d[0][0][0] = 1;
            for (int i = 0; i < MAX_LEN; i++)
                for (int sum = 0; sum < d[i].length; sum++)
                    for (int sumSq = 0; sumSq < d[i][sum].length; sumSq++)
                        if (d[i][sum][sumSq] > 0) {
                            int hi = (i == 0) ? digitHigh : 9;
                            for (int k = 0; k <= hi; k++) {
                                d[i + 1][sum + k][sumSq + k * k] += d[i][sum][sumSq];
                            }
                        }
        }


        // save memory by smart allocation
        D_CACHE = new long[10][MAX_LEN + 1][][];
        for (int digitHigh = 0; digitHigh <= 9; digitHigh++) {
            long[][][] d = D_CACHE[digitHigh];
            for (int i = 0; i <= MAX_LEN; i++) {
                d[i] = new long[(MAX_LEN - i) * 9 + 1][(MAX_LEN - i) * 9 * 9 + 1];
            }
        }
        for (long[][][] v1 : D_CACHE)
            for (long[][] v2 : v1)
                for (long[] v3 : v2) {
                    Arrays.fill(v3, -1);
                }


        FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM = new int[MAX_SUM_SQ];
        P1_HI = new int[MAX_SUM_SQ][MAX_LEN + 1];
        P2_HI = new int[MAX_SUM_SQ][MAX_LEN + 1];
        for (int i = 0; i < MAX_SUM_SQ; i++) {

            // first prime >= i
            FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM[i] = -1;
            for (int j = 0; j < PRIME_COUNT; j++)
                if (PRIMES[j] >= i) {
                    FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM[i] = j;
                    break;
                }

            Arrays.fill(P1_HI[i], -1);
            for (int len = 0; len <= MAX_LEN; len++) {
                int dLen = D_COUNT[0][len].length;
                for (int j = 0; j < PRIME_COUNT; j++)
                    if (PRIMES[j] - i < dLen) {
                        P1_HI[i][len] = j;
                    }
            }

            Arrays.fill(P2_HI[i], -1);
            for (int len = 0; len <= MAX_LEN; len++) {
                int dLen = D_COUNT[0][len][0].length;
                for (int j = 0; j < PRIME_COUNT; j++)
                    if (PRIMES[j] - i < dLen) {
                        P2_HI[i][len] = j;
                    }
            }
        }

        DC_MIN = new int[10][MAX_LEN + 1][];
        DC_MAX = new int[10][MAX_LEN + 1][];
        for (int digitHigh = 0; digitHigh <= 9; digitHigh++)
            for (int i = 0; i <= MAX_LEN; i++) {
                int p1Len = D_COUNT[digitHigh][i].length;
                DC_MIN[digitHigh][i] = new int[p1Len];
                DC_MAX[digitHigh][i] = new int[p1Len];
                for (int p1 = 0; p1 < p1Len; p1++) {
                    int lo = Integer.MAX_VALUE;
                    int hi = Integer.MIN_VALUE;

                    int p2Len = D_COUNT[digitHigh][i][p1].length;
                    for (int p2 = 0; p2 < p2Len; p2++)
                        if (D_COUNT[digitHigh][i][p1][p2] > 0) {
                            lo = Math.min(lo, p2);
                            hi = Math.max(hi, p2);
                        }

                    DC_MIN[digitHigh][i][p1] = lo;
                    DC_MAX[digitHigh][i][p1] = hi;
                }
            }

        for (int p1 = 0; p1 < MAX_SUM_SQ; p1++)
            for (int p2 = 0; p2 < MAX_SUM_SQ; p2++)


                timePrecalc = System.currentTimeMillis() - timeStart;
    }

    private void solve() throws IOException {
        // stress();
        // timing();

        int tc = nextInt();
        for (int tcIdx = 0; tcIdx < tc; tcIdx++) {
            long a = nextLong();
            long b = nextLong();
            out.println(solveFast(a, b));
        }
    }

    private void stress() {
        int maxN = 1000;
        for (int a = 1; a <= maxN; a++) {
            System.out.println("Stress (A): " + a);
            for (int b = a; b <= maxN; b++) {
                long ans1 = solveFast(a, b);
                long ans2 = solveNaive(a, b);
                if (ans1 != ans2) {
                    throw new IllegalStateException(a + " - " + b + ": " + ans1 + " vs. " + ans2);
                }
            }
        }

        Random r = new Random(123456789L);
        int maxTc = 400;
        long lo = 0;
        long hi = 1000000000000000000L;

        for (int tc = 0; tc < maxTc; tc++) {
            System.out.println("Stress (B): " + tc);
            long a = r.nextLong();
            a %= hi;
            if (a < 0) {
                a += hi;
            }

            if (a < lo || a > hi) {
                throw new IllegalStateException();
            }

            int len = r.nextInt(1000000);
            long b = Math.min(a + len, hi);

            long ans1 = solveFast(a, b);
            long ans2 = solveNaive(a, b);
            if (ans1 != ans2) {
                throw new IllegalStateException(a + " - " + b + ": " + ans1 + " vs. " + ans2);
            }
        }
        System.err.println("Stress test passed");
    }

    private void timing() {
        int tc = 10000;
        Random r = new Random();

        for (int tcIdx = 0; tcIdx < tc; tcIdx++) {
            long a = randomLong(r);
            long b = randomLong(r);
            if (a > b) {
                long t = a; a = b; b = t;
            }
            solveFast(a, b);
        }
        System.err.println("Timing test finished");
    }

    private long randomLong(Random r) {
        long a = 0;

        int len = 18 + r.nextInt(1);
        for (int i = 0; i < len; i++) {
            int digit = r.nextInt(10);
            while (i == 0 && digit == 0) {
                digit = r.nextInt(10);
            }
            a *= 10;
            a += digit;
        }

        if (a < 0 || a > 1000000000000000000L) {
            throw new IllegalStateException();
        }
        return a;
    }

    // [lo, hi] [0, 9] ... [0, 9] - has length 'len' digits
    private long solveFast(int firstDigitHi, int len, int sumInit, int sumSqInit) {
        if (firstDigitHi < 0) {
            return 0;
        }

        if (len == 19) {
            // the only way to get here is 10^18
            // returning pre-calculated value to save some memory on the D_COUNT array
            return 65931412787268351L;
        }

        if (D_CACHE[firstDigitHi][len][sumInit][sumSqInit] != -1) {
            return D_CACHE[firstDigitHi][len][sumInit][sumSqInit];
        }

        /*
        long[][] d = D_COUNT[firstDigitHi][len];
        long result = 0;
        for (int sum = 0; sum < d.length; sum++)
            if (IS_PRIME[sum + sumInit])
                for (int sumSq = 0; sumSq < d[sum].length; sumSq++)
                    if (IS_PRIME[sumSq + sumSqInit]) {
                        result += d[sum][sumSq];
                    }
        */

        /*
        long[][] d = D_COUNT[firstDigitHi][len];
        long result = 0;

        int p1Lo = FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM[sumInit];
        int p1Hi = P1_HI[sumInit][len];

        int p2Lo = FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM[sumSqInit];
        int p2Hi = P2_HI[sumSqInit][len];

        for (int p1Idx = p1Lo; p1Idx <= p1Hi; p1Idx++) {
            int p1 = PRIMES[p1Idx] - sumInit;
            for (int p2Idx = p2Lo; p2Idx <= p2Hi; p2Idx++) {
                int p2 = PRIMES[p2Idx] - sumSqInit;
                result += d[p1][p2];
            }
        }
        */

        long[][] d = D_COUNT[firstDigitHi][len];
        long result = 0;

        int p1Lo = FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM[sumInit];
        int p1Hi = P1_HI[sumInit][len];

        for (int p1Idx = p1Lo; p1Idx <= p1Hi; p1Idx++) {
            int p1 = PRIMES[p1Idx] - sumInit;

            int lo = DC_MIN[firstDigitHi][len][p1];
            int hi = DC_MAX[firstDigitHi][len][p1];

            if (lo > hi) {
                continue;
            }

            int p2Idx = FIRST_PRIME_IDX_GREATER_OR_EQ_THAN_SUM[lo + sumSqInit];
            while (p2Idx < PRIME_COUNT) {
                int p2 = PRIMES[p2Idx] - sumSqInit;
                if (p2 > hi) {
                    break;
                }
                result += d[p1][p2];
                p2Idx++;
            }

            /*
            for (int p2 = lo; p2 <= hi; p2++)
                if (IS_PRIME[p2 + sumSqInit]) {
                    result += d[p1][p2];
                }
            */
        }

        D_CACHE[firstDigitHi][len][sumInit][sumSqInit] = result;
        return result;
    }

    // [0, a]
    private long solveFast(long a) {
        if (a < 1) {
            return 0;
        }

        long total = 0;

        // count the right boundary first, and then solve [0, a-1]
        if (isLucky(a)) {
            total++;
        }

        int len = Long.toString(a).length();
        int[] d = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            d[i] = (int) (a % 10);
            a /= 10;
        }

        // 100
        // [000  -  099], prefixLen = 0, firstDigit = 0..0
        // [100  -  ], prefixLen = 1, firstDigit = 0..-1
        // [100  -  ], prefixLen = 2, firstDigit = 0..-1
        // [100]

        // 2514
        // [0000  -  1999], prefixLen = 0, firstDigit = 0..1
        // [2000  -  2499], prefixLen = 1, firstDigitHi = 0..4
        // [2500  -  2509], prefixLen = 2, firstDigitHi = 0..0
        // [2510  -  2513], prefixLen = 3, firstDigitHi = 0..3
        // [2514]

        int sum = 0;
        int sumSq = 0;
        for (int prefixLen = 0; prefixLen < len; prefixLen++) {
            total += solveFast(d[prefixLen] - 1, len - prefixLen, sum, sumSq);
            sum += d[prefixLen];
            sumSq += d[prefixLen] * d[prefixLen];
        }

        return total;
    }

    // [a, b]
    private long solveFast(long a, long b) {
        return solveFast(b) - solveFast(a - 1);
    }

    private long solveNaive(long a, long b) {
        long res = 0;
        for (long k = a; k <= b; k++)
            if (isLucky(k)) {
                res++;
            }
        return res;
    }

    private boolean isLucky(long k) {
        int sum = 0;
        int sumSq = 0;
        while (k > 0) {
            int d = (int) (k % 10);
            sum += d;
            sumSq += d * d;
            k /= 10;
        }

        return IS_PRIME[sum] && IS_PRIME[sumSq];
    }

    public void run() {
        long timeStart = System.currentTimeMillis();

        boolean fileIO = TASK_NAME_FOR_IO.length() > 0;
        try {

            if (fileIO) {
                in = new BufferedReader(new FileReader(FILE_IN));
                out = new PrintWriter(new FileWriter(FILE_OUT));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }

            solve();

            in.close();
            out.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        long timeEnd = System.currentTimeMillis();

        if (fileIO) {
            System.out.println("Time spent: " + (timePrecalc + timeEnd - timeStart) + " ms");
        }
    }

    private String nextToken() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

}
