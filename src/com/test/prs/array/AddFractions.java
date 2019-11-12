package com.test.prs.array;

/* Problem Name is &&& Add Fractions &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 *    execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement addFractions() correctly.
 * 4) If time permits, try to improve your implementation.
 */

public class AddFractions {

    /**
     * int[] addFractions ( int[] fraction1, int[] fraction2 )
     *
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     * Fraction is represented as a two-element array - [ numerator, denominator ]
     * The returned fraction has to be in its simplest form.
     */
    public static int[] addFractions( int[] fraction1, int[] fraction2 ) {
        // TODO: Implement solution
        int[] result = new int[2];


        int n1 = fraction1[0];
        int n2 = fraction2[0];
        int d1 = fraction1[1];
        int d2 = fraction2[1];
        if(d1==d2)
            result =new int[]{n1+n2,d1};
        else{
            if(d1>d2)
            {
                result = solve(fraction1,fraction2);

            }
            else{
                result = solve(fraction2,fraction1);
            }
        }

        result = getSimplestForm(result);

        return result;
    }



    static int[] getSimplestForm(int[] result){
        int gcd =  1;
        if(result[0]>result[1])
            gcd =getGcd(result[0],result[1]);
        else
            gcd =getGcd(result[1],result[0]);
        result[0]/=gcd;
        result[1]/=gcd;

        return result;
    }

    static int getGcd(int a, int b){

        while(a!=b){
            if(a>b)
                a-=b;
            else
                b-=a;
        }
        return a;

    }

    static int[] solve(int[] fraction1, int[] fraction2){

        int[] result = new int[2];

        int n1 = fraction1[0];
        int n2 = fraction2[0];
        int d1 = fraction1[1];
        int d2 = fraction2[1];
        int i=1;
        int a = d1;
        int b = d2;
        while(a<a*b){
            a*=i;
            if(a%b==0){
                result[1]=a;
                break;
            }
            else{

                i++;
            }

        }
        result[0]=(result[1]/d1)*n1+(result[1]/d2)*n2;
        return result;

    }

    /**
     * boolean doTestsPass()
     * Returns true if all the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: implement some tests, please
        // we've included a trivial boilerplate

        int[] result = addFractions( new int[]{ 5, 6 }, new int[]{ 2, 4 } );

        if( result[ 0 ] == 4 && result[ 1 ] == 3 ) {
            System.out.println( "Test passed." );
            return true;
        } else {
            System.out.println( "Test failed." );
            return false;
        }
    }

    public static void main( String[] args ) {
        doTestsPass();
    }
}

