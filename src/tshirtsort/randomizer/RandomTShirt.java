/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tshirtsort.randomizer;

import tshirtsort.models.Color;
import tshirtsort.models.Fabric;
import tshirtsort.models.Size;
import tshirtsort.models.TShirt;


/**
 *
 * @author Odisseas KD
 */
public class RandomTShirt {
    
        public TShirt generate() {        
        Random random = new Random();
        String name = random.getRandomName();
        Color color = random.getRandomColor();
        Size size = random.getRandomSize();
        Fabric fabric = random.getRandomFabric();                
        TShirt randomTShirt = new TShirt(name, color, size, fabric);        
        return(randomTShirt);
        
    }
}
