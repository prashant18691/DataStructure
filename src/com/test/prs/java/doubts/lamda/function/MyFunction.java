package com.test.prs.java.doubts.lamda.function;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.IntFunction;

public class MyFunction {
    @Test
    public  void test1() {
        Function<Integer,String> intToString1 = i -> String.valueOf(i);
        Function<Integer,String> intToString2 = Object::toString;

        Function<String,String> quote = s -> "'"+s+"'";
        Function<Integer ,String> quoteIntToString = quote.compose(intToString1);

        Assert.assertEquals("'5'",quoteIntToString.apply(5));

        IntFunction<Long> intToLongFunction1 = i-> Long.valueOf(i);
        IntFunction<Long> intToLongFunction2 = Long::valueOf;

//        DoubleToIntFunction doubleToIntFunction1 = i->Do

    }
}
