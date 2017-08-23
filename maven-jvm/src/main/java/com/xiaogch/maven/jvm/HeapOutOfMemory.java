package com.xiaogch.maven.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemory {

    public static void main(String...argvs) {
        List<HeapOutOfMemory> list = new ArrayList<HeapOutOfMemory>();
        while(true) {
            list.add(new HeapOutOfMemory());
        }

    }

}
