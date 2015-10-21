package javaShell;

public class SortTest {
    public static void main(String[] args) {
        Integer[] list1 = {7, 12, 19, 3, 18, 4, 2, 6, 15, 11};
        Integer[] list2 = {16, 1, 5, 9, 13, 20, 17, 8, 10, 14};
        Object finalList[] = new Object[list1.length + list2.length];
        Thread sortThread1 = new Thread(new SortThread(list1));
        Thread sortThread2 = new Thread(new SortThread(list1));
        sortThread1.start();
        sortThread2.start();
        try {
            sortThread1.join();
            sortThread2.join();
        } catch (InterruptedException ie) {
            Thread mergeThread = new Thread(new MergeThread(list1, list2, finalList));
            mergeThread.start();
            try {
                mergeThread.join();
            } catch (InterruptedException e) {
            }
            for(Object element: finalList) {
                System.out.println(element + " ");
                System.out.println();
            }
        }
    }
}
