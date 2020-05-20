/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.sorting;

import java.util.List;
import tshirtsort.models.TShirt;

/**
 *
 * @author Odisseas KD
 */
public class QuickSort {

    //boolean sortType, sortType == true, ASC -- sortType == true, DESC
    //int sortByProperty, sortyByProperty == 1, Size -- sortyByProperty == 2, Color -- sortyByProperty == 3, Fabric
    public void sort(List<TShirt> arr, int low, int high, boolean sortType, int sortByProperty) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high, sortType, sortByProperty);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1, sortType, sortByProperty);
            sort(arr, pi + 1, high, sortType, sortByProperty);
        }
    }

    //boolean sortType, sortType == true, ASC -- sortType == true, DESC 
    //int sortByProperty, sortyByProperty == 1, Size -- sortyByProperty == 2, Color -- sortyByProperty == 3, Fabric
    int partition(List<TShirt> arr, int low, int high, boolean sortType, int sortByProperty) {
        TShirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot 
            switch (sortByProperty) {
                case 1: //by Size
                    if (sortType) {
                        if (arr.get(j).getSize().ordinal() < pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getSize().ordinal() > pivot.getSize().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                case 2: //by Color
                    if (sortType) {
                        if (arr.get(j).getColor().ordinal() < pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getColor().ordinal() > pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                case 3: //by Fabric
                    if (sortType) {
                        if (arr.get(j).getFabric().ordinal() < pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    } else {
                        if (arr.get(j).getFabric().ordinal() > pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            TShirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        TShirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }
}
