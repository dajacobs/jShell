package javaShell;

import static java.util.Arrays.sort;

public class SortThread implements Runnable {
    Object[] value;
    public SortThread(Object[] value) {
        this.value = value;
    }
    @Override
    public void run() {
        sort(value);
    }
}