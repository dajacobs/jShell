package multiThread;

import multiThread.MergeThread;

public class SortTest {
    public static void main(String[] args) {
        Integer[] list1 = {7, 12, 19, 3, 18, 4, 2, 6, 15, 11};
        Integer[] list2 = {16, 1, 5, 9, 13, 20, 17, 8, 10, 14};
        
        Object finalList[] = new Object[list1.length + list1.length];
        
        Thread sortThreadOne = new Thread(new SortThread(list1));
        Thread sortThreadTwo = new Thread(new SortThread(list2));
        sortThreadOne.start();
        sortThreadTwo.start();
        try {
            sortThreadOne.join();
            sortThreadTwo.join();
        } catch (InterruptedException ie) {
        }
        Thread mergeThread = new Thread(new MergeThread(list1, list2, finalList));
        mergeThread.start();
        try { 
            mergeThread.join(); 
        } catch (InterruptedException ie) { 
        }
            
        for (Object element : finalList) { 
            System.out.print(element + " "); 
        }
        System.out.println();
    }
}