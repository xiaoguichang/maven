package com.xiaogch.maven.jvm;

import java.util.ArrayList;
import java.util.List;

public class JconsoleMonitor {

    public static void main(String...argvs) {
        List<ObjectMonitor> list = new ArrayList<ObjectMonitor>();
        for (int i = 0 ; i < 1000 ; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new ObjectMonitor());
        }

    }

}

class ObjectMonitor {
    //64KB
    private byte[] array = new byte[64*1024];
}

