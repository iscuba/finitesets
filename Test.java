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

    public int randNum(int min, int max) {
        Random rand = new Random();
        int randNum = rand.nextInt((max - min) + 1) + min;
        return randNum;
    }

    public FiniteSets randSet(FiniteSets start, int length) {
        if (start.cardinality() == length) {
            return start;
        } else {
            int num = randNum(0, 100);
            if (start.member(num)) {
                return randSet(start, length);
            } else {
                return randSet(start.add(num), length);
            }
        }
    }
    
    public boolean testUnionSubset(FiniteSets set1, FiniteSets set2){
        return ((set1.subset(set1.union(set2))) && (set2.subset(set1.union(set2))));
    }
    
    public boolean testMemberAdd(FiniteSets set1, int num){
        return (set1.add(num).member(num));
    }
    
    public boolean testAddCardinality(FiniteSets set1, int num){
        return ((set1.cardinality() + 1) == (set1.add(num).cardinality()));
    }
 
    // I don't think this is supposed to be like this 
    public boolean testUnionMember(FiniteSets set1, FiniteSets set2, int num){
        if(set1.union(set2).member(num)){
            return (set1.member(num)||(set2.member(num)));
        } else {
            System.out.println("the number was not a member of the set");
            return (set1.union(set2).member(num));
        }      
    }
    
    public boolean TestAddRemoveEqual(FiniteSets set1, int num){
        
    }

   public static void main(String[] args) {
        Leaf bloom = new Leaf();

    }
}
