package com.xiaogch.maven.jvm;

public class ReferenceCount {

    protected Object instance;

    private byte[] arr = new byte[1024*1024*10];

    public static void main(String...args) {
        ReferenceCount a = new ReferenceCount();
        ReferenceCount b = new ReferenceCount();
        a.instance = b;
        b.instance = a;
        a = null;
        b = null;
        System.gc();
    }



}
