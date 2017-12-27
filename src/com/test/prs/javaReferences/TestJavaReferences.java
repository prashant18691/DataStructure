package com.test.prs.javaReferences;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestJavaReferences {
    public static void main(String[] args) {
      A a = new A(); // Strong Reference
     /* System.out.println(a);
      a = null; //object available for GC
        System.gc();
      System.out.println(a);*/
        /*SoftReference<A> softReference = new SoftReference<A>(a); // GC only when JVM needs memory
        a = null;
        System.gc();
        a = softReference.get();
        System.out.println(a);*/

        /*WeakReference<A> weakReference = new WeakReference<A>(a); // likely to be garbage collected when JVM runs garbage collector thread. JVM doesn’t show any regard for weak references.
        a = null;
        System.gc();
        a = weakReference.get();
        System.out.println(a);*/

        PhantomReference<A> phantomReference = new PhantomReference<A>(a, new ReferenceQueue<A>()); // GC collected when called
        a = null;
        System.gc();
        a = phantomReference.get();
        System.out.println(a);

        /*eligible for garbage collection. But, before removing them from the memory,
        JVM puts them in a queue called ‘reference queue’ . They are put in a reference
        queue after calling finalize() method on them. You can’t retrieve back the objects
        which are being phantom referenced. That means calling get() method on phantom reference
        always returns null.*/
    }
}

class A{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called");
    }
}
