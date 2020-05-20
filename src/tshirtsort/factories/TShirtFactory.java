/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.factories;

import java.util.ArrayList;
import java.util.List;
import tshirtsort.models.TShirt;
import tshirtsort.randomizer.RandomTShirt;

/**
 *
 * @author Odisseas KD
 */
public class TShirtFactory {
    
    public List<TShirt> tShirtGenerateX(int x) {
        RandomTShirt rd = new RandomTShirt();
        List<TShirt> listOfTShirts = new ArrayList();
        for (int i = 0; i < x; i++) {
            listOfTShirts.add(rd.generate());            
        }
        return listOfTShirts;
    }
    
}
