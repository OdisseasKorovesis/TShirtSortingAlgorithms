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
public class BubbleSort {

    //boolean sortType, sortType == true, ASC -- sortType == true, DESC
    //int sortByProperty, sortyByProperty == 1, Size -- sortyByProperty == 2, Color -- sortyByProperty == 3, Fabric    
    public void bubbleSort(List<TShirt> arr, boolean sortType, int sortByProperty) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                switch (sortByProperty) {
                    case 1: //by Size
                        if (sortType) {
                            //asc
                            if (arr.get(j).getSize().ordinal() > arr.get(j + 1).getSize().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            } else {
                                //desc
                                if (arr.get(j).getSize().ordinal() < arr.get(j + 1).getSize().ordinal()) {
                                    // swap arr[j+1] and arr[i] 
                                    TShirt temp = arr.get(j);
                                    arr.set(j, arr.get(j + 1));
                                    arr.set(j + 1, temp);
                                }
                            }
                        }
                        break;
                    case 2: // by Color
                        if (sortType) {
                            //asc
                            if (arr.get(j).getColor().ordinal() > arr.get(j + 1).getColor().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            } else {
                                //desc
                                if (arr.get(j).getColor().ordinal() < arr.get(j + 1).getColor().ordinal()) {
                                    // swap arr[j+1] and arr[i] 
                                    TShirt temp = arr.get(j);
                                    arr.set(j, arr.get(j + 1));
                                    arr.set(j + 1, temp);
                                }
                            }
                        }
                        break;
                    case 3: // by Fabric
                        if (sortType) {
                            //asc
                            if (arr.get(j).getFabric().ordinal() > arr.get(j + 1).getFabric().ordinal()) {
                                // swap arr[j+1] and arr[i] 
                                TShirt temp = arr.get(j);
                                arr.set(j, arr.get(j + 1));
                                arr.set(j + 1, temp);
                            } else {
                                //desc
                                if (arr.get(j).getFabric().ordinal() < arr.get(j + 1).getFabric().ordinal()) {
                                    // swap arr[j+1] and arr[i] 
                                    TShirt temp = arr.get(j);
                                    arr.set(j, arr.get(j + 1));
                                    arr.set(j + 1, temp);
                                }
                            }
                        }
                        break;
                }
            }
        }
    }
}
