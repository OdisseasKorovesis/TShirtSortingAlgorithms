/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.services;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;
import tshirtsort.sorting.BucketSort;

/**
 *
 * @author Odisseas KD
 */
public class BucketSortService {
    public void bucketSort(List<TShirt> shirts, BucketSort bus, boolean shortType, int sortByProperty) {
        long startTime;
        long endTime;
        long quickShortTime;
        List<TShirt> sorted_shirts = new ArrayList();
        switch (sortByProperty) {
            case 1:
                startTime = System.currentTimeMillis();
                sorted_shirts = bus.sort(shirts, 6, shortType, sortByProperty);
                endTime = System.currentTimeMillis();
                quickShortTime = endTime - startTime;
                if (shortType) {
                    System.out.println("Time Lapsed for bus by Size ASC: " + quickShortTime);
                } else {
                    System.out.println("Time Lapsed for bus by Size DESC: " + quickShortTime);
                }
                for (TShirt shirt : sorted_shirts) {
                    System.out.println(shirt);
                }
                break;
            case 2:
                startTime = System.currentTimeMillis();
                sorted_shirts = bus.sort(shirts, 6, shortType, sortByProperty);
                endTime = System.currentTimeMillis();
                quickShortTime = endTime - startTime;
                if (shortType) {
                    System.out.println("Time Lapsed for bus by Color ASC: " + quickShortTime);
                } else {
                    System.out.println("Time Lapsed for bus by Color DESC: " + quickShortTime);
                }
                for (TShirt shirt : sorted_shirts) {
                    System.out.println(shirt);
                }
                break;
            case 3:
                startTime = System.currentTimeMillis();
                sorted_shirts = bus.sort(shirts, 6, shortType, sortByProperty);
                endTime = System.currentTimeMillis();
                quickShortTime = endTime - startTime;
                if (shortType) {
                    System.out.println("Time Lapsed for bus by Fabric ASC: " + quickShortTime);
                } else {
                    System.out.println("Time Lapsed for bus by Fabric DESC: " + quickShortTime);
                }
                for (TShirt shirt : sorted_shirts) {
                    System.out.println(shirt);
                }
                break;
        }
    }
}
