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

    public void testUnionSubset(FiniteSets set1, FiniteSets set2) {
        if ((set1.subset(set1.union(set2))) && (set2.subset(set1.union(set2)))) {
            System.out.println("Success for testUnionSubset");
        } else {
            System.out.println("Failure for testUnionSubset");
        }
    }

    public void testMemberAdd(FiniteSets set1, int num) {
        if (set1.add(num).member(num)) {
            System.out.println("Success for testMemberAdd");
        } else {
            System.out.println("Fail for testMemberAdd");
        }
    }

    public void testAddCardinality(FiniteSets set1, int num) {
        if ((set1.cardinality() + 1) == (set1.add(num).cardinality())) {
            System.out.println("Success for testAddCardinality");
        } else {
            System.out.println("Fail for testAddCardinality");
        }
    }

    public void testUnionMember(FiniteSets set1, FiniteSets set2, int num) {
        if (set1.union(set2).member(num) == (set1.member(num) || (set2.member(num)))) {
            System.out.println("success for testUnionMember");
        } else if (!(set1.member(num) || set2.member(num))) {
            System.out.println("the number was not a member of the set: testUnionMember");
        } else {
            System.out.println("Fail for testUnionMember");
        }
    }

    public void testAddRemoveEqual(FiniteSets set1, int num) {
        if (set1.add(num).remove(num).equal(set1)) {
            System.out.println("Success for testAddRemoveEqual");
        } else {
            System.out.println("Fail for testAddRemoveEqual");
        }
    }

    public void testEqualUnionInterDiff(FiniteSets set1, FiniteSets set2, int num) {
        if ((set1.inter(set2).union(set1.diff(set2).union(set2.diff(set1)))).equal(set1.union(set2))) {
            System.out.println("Success for testEqualUnionInterDiff");
        } else {
            System.out.println("Fail for testEqualUnionInterDiff");
        }

    }

    public void testUnionLeaf(FiniteSets set, Leaf leaf) {
        if (set.union(leaf) == set) {
            System.out.println("success for testUnionLeaf");
        } else {
            System.out.println("Fail for testUnionLeaf");
        }
    }

    public void testEmptyInter(FiniteSets set, Leaf leaf) {
        if (leaf.inter(set).isEmptyHuh()) {
            System.out.println("success for testEmptyInter");
        } else {
            System.out.println("Fail for testEmptyInter");
        }
    }
    
    public void testDiffEmpty(FiniteSets set, Leaf leaf){
        if (set.diff(leaf).equal(set))
             System.out.println("success for testDiffEmpty");
        else{
             System.out.println("fail for testDiffEmpty");
        }
    }
    
    public void testInter(FiniteSets set1, FiniteSets set2, int elt){
        if(set1.add(elt).inter(set2.add(elt)).isEmptyHuh())
            System.out.println("fail for testInter");
        else {
            System.out.println("Success for testDiffEmpty");
        }
    }
    
    public void 

    public static void main(String[] args) {
        Leaf bloom = new Leaf();

    }
}
