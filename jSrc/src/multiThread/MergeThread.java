package multiThread;

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
    @Override
    public void run() {
        int x = 0;
        int y = 0;
        int z = 0;
        while((x < list1.length) && y < list2.length) {
            if(((Comparable)list1[x]).compareTo(list2[y]) < 0) {
                mList[z++] = list1[x++];
            } else {
                mList[z++] = list2[y++];
            }
        }
        if(x < list1.length) {
            for(int i = x; i < list1.length; i++) {
                mList[z++] = list1[i];
            }
        } else {
            for(int i = y; i < list2.length; i++) {
                mList[z++] = list2[i];
            }
        }
    }
}