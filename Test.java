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
    
    public void testUnionSubset(FiniteSets set1, FiniteSets set2){
        if ((set1.subset(set1.union(set2))) && (set2.subset(set1.union(set2))))
            System.out.println("Success");
        else {System.out.println("Failure");}
    }
    
    public void testMemberAdd(FiniteSets set1, int num){
        if (set1.add(num).member(num))
            System.out.println("Success");
        else {System.out.println("Fail");}
    }
    
    public void testAddCardinality(FiniteSets set1, int num){
        if ((set1.cardinality() + 1) == (set1.add(num).cardinality()))
            System.out.println("Success");
        else { System.out.println("Fail");}
    }
 
    public void testUnionMember(FiniteSets set1, FiniteSets set2, int num){
        if(set1.union(set2).member(num)==(set1.member(num)||(set2.member(num)))){
            System.out.println("success");
        } else if (!(set1.member(num)||set2.member(num))){
            System.out.println("the number was not a member of the set");
        } else { 
             System.out.println("Fail ");
        }
    }
    
    public void testAddRemoveEqual(FiniteSets set1, int num){
        if (set1.add(num).remove(num).equal(set1))
            System.out.println("Success");
        else {
            System.out.println("Fail");
        }
    }    
    
    public void testEqualUnionInterDiff(FiniteSets set1, FiniteSets set2, int num){
        if ((set1.inter(set2).union(set1.diff(set2).union(set2.diff(set1)))).equal(set1.union(set2)))
            System.out.println("Success");
        else{
            System.out.println("Fail");
        }
            
    }
    
    public void testUnionLeaf(FiniteSets set, Leaf leaf){
        if (set.union(leaf) == set){
             System.out.println("success");
        } else {
             System.out.println("Fail");
        }
    }

   public static void main(String[] args) {
        Leaf bloom = new Leaf();

    }
}
