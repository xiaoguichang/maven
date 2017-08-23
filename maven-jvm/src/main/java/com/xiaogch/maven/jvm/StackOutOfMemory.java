package com.xiaogch.maven.jvm;

public class StackOutOfMemory {

    public static void main(String...param){
        for (;;) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    while (true) {

                    }
                }
            });
            t.start();
        }
    }


}
