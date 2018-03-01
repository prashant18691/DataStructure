package com.test.prs.gcd;

import java.util.Scanner;

public class GcdSum {

    public static final int MAXN = 1000005;
    public static final int MAXV = 500000;
    public static final  long MOD = 1000000007;
    static int N, Q;
    static long[] a,phi,p,BIT;
    GcdSum(){
        a = new long[MAXN];
        phi = new long[MAXV + 5];
        p = new long[MAXV + 5];
        BIT = new long[MAXN];

    }

    void compute_phi() {// calculate no of  coprimes less than n ; Euler’s Totient function
        for(int i = 1; i <= MAXV; i++) phi[i] = i;
        for(int i = 2; i <= MAXV; i++)
            if (phi[i] == i) { // prime number
                for(int j = i; j <= MAXV; j += i) {
                    phi[j] -= phi[j] / i;
                    phi[j] = phi[j]%MOD;
                }
            }
    }

    void compute_pillai() {
        for(int i = 1; i <= MAXV; i++)
            for(int j = i; j <= MAXV; j += i) {
                p[j] += i * phi[j / i];
                p[j] = p[j]%MOD;
            }
    }

    long query(int i) {
        long sum = 0;
        for(; i > 0; i -= i&-i) {
            sum += BIT[i];
            sum = sum%MOD;
        }
        return sum;
    }

    void update(int i, long val) {
        for(; i <= N; i += i&-i) {
            BIT[i] += val;
            BIT[i] = BIT[i]%MOD;
        }
    }

    public static void main(String[] args) {
        GcdSum g = new GcdSum();
        g.compute_phi();
        g.compute_pillai();

        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int[] in = new int[N];
        for (int i = 0; i < N; i++) {
            in[i] = s.nextInt();
            g.update(i+1, p[in[i]]);
        }
        Q = s.nextInt();
        for (int i = 0; i < Q; i++) {
            String opr = s.next();
            int x = Integer.parseInt(s.next());
            int y = Integer.parseInt(s.next());
            if (opr.equals("U")) {
                g.update(x, (-p[in[x]] + p[y])%MOD);
                a[x] = y;
            } else if (opr.equals("C")) {
                System.out.println((g.query(y) - g.query(x) + p[in[x]])%MOD);
            }
        }

    }
}
