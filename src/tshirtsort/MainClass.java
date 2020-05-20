/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.factories.TShirtFactory;
import tshirtsort.models.TShirt;
import tshirtsort.services.BubbleSortService;
import tshirtsort.services.BucketSortService;
import tshirtsort.services.QuickSortService;
import tshirtsort.sorting.BubbleSort;
import tshirtsort.sorting.BucketSort;
import tshirtsort.sorting.QuickSort;

/**
 *
 * @author Odisseas KD
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TShirtFactory tf = new TShirtFactory();
        List<TShirt> shirts = tf.tShirtGenerateX(40);
        QuickSort qs = new QuickSort();
        BubbleSort bs = new BubbleSort();
        BucketSort bus = new BucketSort();

        performQuickSort(qs, shirts);
        performBubbleSort(bs, shirts);
        performBucketSort(bus, shirts);
        performBucketSortPerProperty(bus, shirts);
    }

    public static void performQuickSort(QuickSort qs, List<TShirt> shirts) {
        QuickSortService quickSort = new QuickSortService();
        quickSort.quickShort(shirts, qs, true, 1); //quick short size ASC
        quickSort.quickShort(shirts, qs, false, 1); //quick short size DESC
        quickSort.quickShort(shirts, qs, true, 2); //quick short color ASC
        quickSort.quickShort(shirts, qs, false, 2); //quick short color DESC
        quickSort.quickShort(shirts, qs, true, 3); //quick short fabric ASC
        quickSort.quickShort(shirts, qs, false, 3); //quick short fabric DESC
    }

    public static void performBubbleSort(BubbleSort bs, List<TShirt> shirts) {
        BubbleSortService bubbleSort = new BubbleSortService();
        bubbleSort.bubbleSort(shirts, bs, true, 1); //quick short size ASC
        bubbleSort.bubbleSort(shirts, bs, false, 1); //quick short size DESC
        bubbleSort.bubbleSort(shirts, bs, true, 2); //quick short color ASC
        bubbleSort.bubbleSort(shirts, bs, false, 2); //quick short color DESC
        bubbleSort.bubbleSort(shirts, bs, true, 3); //quick short fabric ASC
        bubbleSort.bubbleSort(shirts, bs, false, 3); //quick short fabric DESC
    }

    public static void performBucketSort(BucketSort bus, List<TShirt> shirts) {
        BucketSortService bucketSort = new BucketSortService();
        bucketSort.bucketSort(shirts, bus, true, 1); //quick short size ASC
        bucketSort.bucketSort(shirts, bus, false, 1); //quick short size DESC
        bucketSort.bucketSort(shirts, bus, true, 2); //quick short color ASC
        bucketSort.bucketSort(shirts, bus, false, 2); //quick short color DESC
        bucketSort.bucketSort(shirts, bus, true, 3); //quick short fabric ASC
        bucketSort.bucketSort(shirts, bus, false, 3); //quick short fabric DESC
    }

    public static void performBucketSortPerProperty(BucketSort bus, List<TShirt> tshirts) {

        List<List<TShirt>> subLists = new ArrayList<List<TShirt>>(); // instantiate a List of Lists!

        long startTime = System.currentTimeMillis();                
        List<TShirt> shirtsBySize = bus.sort(tshirts, 6, true, 1);
        long endTime = System.currentTimeMillis();
        long busBySizeTime = endTime - startTime;

        int[] sBySize = new int[7];
        for (int i = 0; i < 7; i++) {
            sBySize[i] = 0;
        }
        for (TShirt tShirt : shirtsBySize) {
            sBySize[tShirt.getSize().ordinal()]++; //sBySize[0] == 2
        }       

        TStruct[] allSizes = new TStruct[7];
        int counter = 0;
        for (int i = 0; i < 7; i++) {
            allSizes[i] = new TStruct();
            if (sBySize[i] == 0) {
                allSizes[i].start = -1;
                allSizes[i].end = -1;
            } else {
                allSizes[i].start = counter; // 0 
                allSizes[i].end = counter + sBySize[i] - 1;
                subLists.add(shirtsBySize.subList(allSizes[i].start, allSizes[i].end + 1)); //mistake corrected
            }
            counter += sBySize[i];
        }

        List<TShirt> finalListASC = new ArrayList();
        for (List<TShirt> list : subLists) {
            startTime = System.currentTimeMillis();       
            List<TShirt> shirtsByColor = bus.sort(list, 6, true, 2);
            endTime = System.currentTimeMillis();
            busBySizeTime += (endTime - startTime); 
            finalListASC.addAll(shirtsByColor);
        }
        
        System.out.println("Time Lapsed for bus by Size and Color ASC: " + busBySizeTime);        
        for (TShirt tShirt : finalListASC) {
            System.out.println(tShirt);
        }        

        List<TShirt> finalListDESC = new ArrayList();
        for (List<TShirt> list : subLists) {
            startTime = System.currentTimeMillis(); 
            List<TShirt> shirtsByColor = bus.sort(list, 6, false, 2);
            endTime = System.currentTimeMillis();
            busBySizeTime += (endTime - startTime); 
            finalListDESC.addAll(shirtsByColor);
        }
        System.out.println("Time Lapsed for bus by Size and Color DESC: " + busBySizeTime);        
        for (TShirt tShirt : finalListDESC) {
            System.out.println(tShirt);
        }        

        // from here on down, incomplete implementation of triple sort
        //commented out for output purposes
//        List<Integer[]> sByColor = new ArrayList<Integer[]>();
//        for(int i = 0; i <= subLists.size(); i++) {
//            sByColor.add(new Integer[7]);
//            Integer[] t = new Integer[7];
//            for (Integer integer : sByColor.get(sByColor.size() - 1)) {
//                integer = 0;
//            }
//        }
//        int sByColorCounter = 0;
//        for(List<TShirt> sList: subLists) {
//            List<TShirt> shirtsByColor = bus.sort(sList, 6, true, 2);
//            for(TShirt tShirt : sList) {
//                Integer[] t =  sByColor.get(sByColorCounter);
//                if(t[tShirt.getColor().ordinal()] == null) t[tShirt.getColor().ordinal()] = 0;
//                t[tShirt.getColor().ordinal()]++;
//            }
//            sByColorCounter++;
//        }
//        counter = 0;
//        for (Integer[] integers : sByColor) {
//            System.out.println("counter: " + counter);
//            for (int i =0; i<integers.length; i++) {
//                System.out.println(i + ": " + integers[i]);
//            }
//            counter++;
//        }                   
    }

    static class TStruct {

        public int start;
        public int end;
    }
}
