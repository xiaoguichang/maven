package com.xiaogch.maven.jvm;

public class MemoryAllocation {


    public static void main(String...argvs) {
        byte[] a , b , c, d;
        a = new byte[2*1024*1024];

        b = new byte[2*1024*1024];

        c = new byte[2*1024*1024];

        d = new byte[4*1024*1024];
    }
}
