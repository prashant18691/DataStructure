package com.test.prs.challenges;

import java.util.Arrays;
import java.util.Scanner;
 /*
public class LuckyNumbers {

    static boolean[] primes = new boolean[1000001];
    static {
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i=2;i<primes.length;i++)
            if(primes[i]){
            for(int j=2;i*j<primes.length;j++)
                primes[i*j] = false;
            }
    }

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            long a = s.nextLong();
            long b = s.nextLong();
            int count = 0;
            for(long j=a;j<=b;j++){
                int sum=0,sum_sq=0;
                long i = j;
                   while(i>9){
                       long r = i%10;
                       i=i/10;
                       sum+=r;
                       sum_sq+=r*r;
                   }
                   sum+=i;
                   sum_sq+=i*i;
                   if(primes[sum] && primes[sum_sq])
                       count++;
            }
            System.out.println(count);
            t--;
        }
    }

   private static boolean isPrime(int  n){
        if(n<=1)
            return false;
        for(int i=2;i<Math.floor(Math.sqrt(n)+1);i++)
            if(n%i==0)
                return false;

        return true;
    }

*/

 /*   static int MAX_SUM_SQ = 1458; // max sum of squares of digits 10^18;(max num for which given sum is max: 9999...18 times) (9)^2*18
    static int MAX_SUM = 162;   // max sum of digits 10^18;(max num for which given sum is max: 9999...18 times) 9*18
    static int MAX_LENGTH = 19; // 10^18
    static int digits[] = new int[MAX_LENGTH + 1];
    static boolean[] primes = new boolean[MAX_SUM_SQ+1];
    static long[][][] dp = new long[MAX_LENGTH+1][MAX_SUM+1][MAX_SUM_SQ+1];
    static {
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i=2;i<=MAX_SUM_SQ;i++)
            if(primes[i]){
                for(int j=2;i*j<=MAX_SUM_SQ;j++)
                    primes[i*j] = false;
            }
    }

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            long a = s.nextLong();
            long b = s.nextLong();
            System.out.println(solve(b)-solve(a-1));
            t--;
        }
    }

    private static long solve(long a) {
        if(a==0)
            return 0;
        int len =0;
        while(a>0){
            digits[len++] = (int) (a%10);
            a/=10;
        }
        return 0;
    }

}*/

    // Recursive java program for
// coin change problem.
    class LuckyNumbers {
        static Long[][][] dp;
        static boolean[] primes;
        static final long maxx=9*18, maxx2=9*9*18;

        static long dpCalculate(int c, int x, int x2){
            //  System.err.println(c+" "+x+" "+x2);
            if(x>maxx || x2>maxx2)
                return 0;
            if(c==0){
                if(primes[x] && primes[x2])
                    return 1;
                else
                    return 0;
            }
            if(dp[c][x][x2]==null){
                long aux=0;
                for(int i=0; i<10; i++){
                    aux+=dpCalculate(c-1,x+i,x2+i*i);
                }
                dp[c][x][x2]=aux;
            }
            return dp[c][x][x2];
        }

        static long calculate(long max){
            if(max<11)
                return 0;
            String str = String.valueOf(max);
            int aux=0, aux2=0, size=str.length();
            long ans=0;
            for(int i=0; i<size; i++){
                long dig=(long)(str.charAt(i)-'0');
                for(int j=0; (size-i==1?j<=dig:j<dig); j++){
                    ans+=dpCalculate(size-i-1,j+aux,j*j+aux2);
                }
                aux+=dig;
                aux2+=dig*dig;
            }
            //      System.err.println(ans);
            return ans;
        }

        static long luckyNumbers(long a,long b) {
            return calculate(b)-calculate(a-1);
        }

        static void fillPrimes(){
            primes=new boolean[1500];
            primes[2]=true;
            for(int i=3; i<1500; i+=2){
                boolean aux=true;
                for(int j=3; j<i; j+=2){
                    if(i%j==0){
                        aux=false;
                        break;
                    }
                }
                primes[i]=aux;
            }
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            long res;
            dp= new Long[19][9*18+1][9*9*18+1];
            fillPrimes();
            int _a_size = Integer.parseInt(in.nextLine());
            long _a,_b;
            for(int _a_i = 0; _a_i < _a_size; _a_i++) {
                String next = in.nextLine();
                String[] next_split = next.split(" ");
                _a=Long.parseLong(next_split[0]);
                _b=Long.parseLong(next_split[1]);
                res = luckyNumbers(_a,_b);
                System.out.println(res);
            }
        }
    }

