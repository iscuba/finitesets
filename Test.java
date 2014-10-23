/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitesets;

import static finitesets.BSTree.empty;
import java.util.*;

/**
 *
 * @author Isabella
 */
public class Test {

    public static int randNum(int min, int max) {
        Random rand = new Random();
        int randNum = rand.nextInt((max - min) + 1) + min;
        return randNum;
    }

    public static FiniteSets randSet(FiniteSets start, int length) {
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

    public static void checkEmpty(FiniteSets MT) {
        if (MT.isEmptyHuh()) {
            System.out.println("Success for checkEmpty");
        } else {
            System.out.println("Fail for checkAdd");
        }
    }

    public static void checkAdd(FiniteSets set) {
        int num = randNum(0, 100);
        FiniteSets set2 = set.add(num);
        if (set2.member(num)) {
            System.out.println("Success for checkAdd");
        } else {
            System.out.println("Fali for checkAdd");
        }
    }

    public static void checkRemove(FiniteSets set) {
        int num = randNum(0, 100);
        FiniteSets set2 = set.add(num);
        if (!set2.remove(num).member(num)) {
            System.out.println("Success for checkRemove");
        } else {
            System.out.println("Fail for checkRemove ");
        }
    }

    public static void testUnionSubset(FiniteSets set1, FiniteSets set2) {

        if ((set1.subset(set1.union(set2))) && (set2.subset(set1.union(set2)))) {
            System.out.println("Success for testUnionSubset");
        } else {
            System.out.println("Failure for testUnionSubset");
        }
    }

    public static void testMemberAdd(FiniteSets set1, int num) {
        if (set1.add(num).member(num)) {
            System.out.println("Success for testMemberAdd");
        } else {
            System.out.println("Fail for testMemberAdd");
        }
    }

    public static void testAddCardinality(FiniteSets set1, int num) {
        int test = set1.add(num).cardinality();
        if (((set1.cardinality() + 1) == test) || (set1.cardinality() == test)) {
            System.out.println("Success for testAddCardinality");
        } else {
            System.out.println("Fail for testAddCardinality");
        }
    }

    public static void testUnionMember(FiniteSets set1, FiniteSets set2, int num) {
        if (set1.union(set2).member(num) == (set1.member(num) || (set2.member(num)))) {
            System.out.println("Success for testUnionMember");
        } else if (!(set1.member(num) || set2.member(num))) {
            System.out.println("the number was not a member of the set: testUnionMember");
        } else {
            System.out.println("Fail for testUnionMember");
        }
    }

    public static void testAddRemoveEqual(FiniteSets set1, int num) {
        if (((set1.add(num)).remove(num)) == (set1)) {
            System.out.println("Success for testAddRemoveEqual");
        } else {
            System.out.println("Fail for testAddRemoveEqual");
        }
    }

    public static void testSubset(FiniteSets set1, FiniteSets set2, FiniteSets set3) {
        if ((set1.union(set2)).subset(set3)
                == (set1.subset(set3) && set2.subset(set3))) {
            System.out.println("Success for testSubset");
        } else {
            System.out.println("Failure for testSubset");
        }
    }

    public static void testEqualUnionInterDiff(FiniteSets set1, FiniteSets set2, int num) {
        if (((set1.inter(set2)).union(set2.diff(set1)).union(set1.diff(set2))).equal(set1.union(set2))) {
            System.out.println("Success for testEqualUnionInterDiff");
        } else {
            System.out.println("Fail for testEqualUnionInterDiff");
        }

    }

    public static void testUnionLeaf(FiniteSets set, Leaf leaf) {
        if (leaf.union(set) == set) {
            System.out.println("success for testUnionLeaf");
        } else {
            System.out.println("Fail for testUnionLeaf");
        }
    }

    public static void testEmptyInter(FiniteSets set, Leaf leaf) {
        if (set.inter(leaf).isEmptyHuh()) {
            System.out.println("success for testEmptyInter");
        } else {
            System.out.println("Fail for testEmptyInter");
        }
    }

    public static void testDiffEmpty(FiniteSets set, Leaf leaf) {
        if (leaf.diff(set).equal(set)) {
            System.out.println("success for testDiffEmpty");
        } else {
            System.out.println("fail for testDiffEmpty");
        }
    }

    public static void testInter(FiniteSets set1, FiniteSets set2, int elt) {
        if (set1.add(elt).inter(set2.add(elt)).isEmptyHuh()) {
            System.out.println("fail for testInter");
        } else {
            System.out.println("Success for testinter");
        }
    }

    public static void checkEqual(FiniteSets EMT, FiniteSets MT) {
        if (EMT.equal(MT)) {
            System.out.println("Success for testEqual");
        } else {
            System.out.println("Fail for testEqual");
        }
    }

    public static void main(String[] args) {

        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());
        checkEmpty(empty());

        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));
        checkAdd(randSet(new Leaf(), randNum(1, 100)));

        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));
        checkRemove(randSet(new Leaf(), randNum(1, 100)));

        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testUnionSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));

        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testMemberAdd(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddCardinality(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testUnionMember(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testAddRemoveEqual(randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));
        testSubset(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)));

        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testEqualUnionInterDiff(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testUnionLeaf(randSet(new Leaf(), randNum(1, 100)), new Leaf());

        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testEmptyInter(randSet(new Leaf(), randNum(1, 100)), new Leaf());

        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());
        testDiffEmpty(randSet(new Leaf(), randNum(1, 100)), new Leaf());

        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));
        testInter(randSet(new Leaf(), randNum(1, 100)), randSet(new Leaf(), randNum(1, 100)), randNum(0, 100));

        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());
        checkEqual(empty(), empty());

    }

}
