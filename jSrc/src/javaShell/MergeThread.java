package javaShell;

public class MergeThread implements Runnable {
    private final Object[] list1;
    private final Object[] list2;
    private final Object[] mList;
    
    // Constructor
    public MergeThread(Object[] list1, Object[] list2, Object[] mList) {
        this.list1 = list1;
        this.list2 = list2;
        this.mList = mList;
    }
    // Runnable method
    public void run() {
        
    }
}