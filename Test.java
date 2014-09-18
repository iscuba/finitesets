/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finitesets;
import java.util.*;
/**
 *
 * @author Isabella
 */
public class Test {
    
    public int randNum(int min, int max){
        Random rand = new Random();
        int randNum = rand.nextInt((max-min) + 1) + min;
        return randNum;
    }
    
    public FiniteSets randSet(FiniteSets start, int length){
        if (start.cardinality()==length){
            return start;
        } else {
            int num = randNum(0 ,100);
            if (start.member(num))
                return randSet(start, length);
            else 
                return randSet(start.add(num), length);
        }
    }
    
    
}
