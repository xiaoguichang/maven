package com.xiaogch.maven.jvm;

public class StackOverflow {

    private int deep = 0;

    public void run() {
        deep ++;
        run();
    }

    public static void main(String...argvs) {
        StackOverflow stackOverflow = new StackOverflow();

        try {
            stackOverflow.run();
        } catch (Throwable able) {
            System.out.println("stack deep is " + stackOverflow.deep);
            able.printStackTrace();
        }

    }
}
