/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.services;

import java.util.List;
import tshirtsort.models.TShirt;
import tshirtsort.sorting.QuickSort;

/**
 *
 * @author Odisseas KD
 */
public class QuickSortService {
    public void quickShort(List<TShirt> shirts, QuickSort qs, boolean shortType, int sortByProperty) {
        long startTime;
        long endTime;
        long quickShortTime;
        switch (sortByProperty) {
            case 1:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, shortType, sortByProperty);
                endTime = System.currentTimeMillis();
                quickShortTime = endTime - startTime;
                if (shortType) {
                    System.out.println("Time Lapsed for qs by Size ASC: " + quickShortTime);
                } else {
                    System.out.println("Time Lapsed for qs by Size DESC: " + quickShortTime);
                }
                for (TShirt shirt : shirts) {
                    System.out.println(shirt);
                }
                break;
            case 2:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, shortType, sortByProperty);
                endTime = System.currentTimeMillis();
                quickShortTime = endTime - startTime;
                if (shortType) {
                    System.out.println("Time Lapsed for qs by Color ASC: " + quickShortTime);
                } else {
                    System.out.println("Time Lapsed for qs by Color DESC: " + quickShortTime);
                }
                for (TShirt shirt : shirts) {
                    System.out.println(shirt);
                }
                break;
            case 3:
                startTime = System.currentTimeMillis();
                qs.sort(shirts, 0, shirts.size() - 1, shortType, sortByProperty);
                endTime = System.currentTimeMillis();
                quickShortTime = endTime - startTime;
                if (shortType) {
                    System.out.println("Time Lapsed for qs by Fabric ASC: " + quickShortTime);
                } else {
                    System.out.println("Time Lapsed for qs by Fabric DESC: " + quickShortTime);
                }
                for (TShirt shirt : shirts) {
                    System.out.println(shirt);
                }
                break;
        }
    }
}
