/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.sorting;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.Size;
import tshirtsort.models.TShirt;

/**
 *
 * @author Odisseas KD
 */
public class BucketSort {

    public List<TShirt> sort(List<TShirt> shirts, int maxValue, boolean sortType, int sortByProperty) {
        // Bucket Sort

        List<TShirt>[] buckets = new ArrayList[maxValue + 1];
        List<TShirt> sorted_shirts = new ArrayList();

        for (int i = 0; i < maxValue + 1; i++) {
            buckets[i] = new ArrayList<TShirt>();
        }

        for (int i = 0; i < shirts.size(); i++) {
            switch (sortByProperty) {
                case 1:
                    buckets[shirts.get(i).getSize().ordinal()].add(shirts.get(i));
                    break;
                case 2:
                    buckets[shirts.get(i).getColor().ordinal()].add(shirts.get(i));
                    break;
                case 3:
                    buckets[shirts.get(i).getFabric().ordinal()].add(shirts.get(i));
                    break;
            }
        }

        if (sortType) {
            for (int i = 0; i < maxValue + 1; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sorted_shirts.add(buckets[i].get(j));
                }
            }
        } else {
            for (int i = maxValue; i >= 0; i--) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    sorted_shirts.add(buckets[i].get(j));
                }
            }
        }

        return sorted_shirts;
    }    

}
