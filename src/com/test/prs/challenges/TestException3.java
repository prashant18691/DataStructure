package com.test.prs.challenges;

import java.io.IOException;

public class TestException3 {
    public static void main(String[] args) {

    }
}

class C{
    void trial() throws Exception, Throwable {

    }
}
class D extends C{
    void trial() throws Throwable {
        throw new Throwable();
    }
}


