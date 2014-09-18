/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finitesets;

/**
 *
 * @author Isabella
 */
public class Leaf implements FiniteSets {

    public Leaf() {
    }

    public FiniteSets empty() {
        return new Leaf();
    }

    public int cardinality() {
        return 0;
    }

    public boolean isEmptyHuh() {
        return true;
    }

    public boolean member(int elt) {
        return false;
    }

    public FiniteSets add(int elt) {
        return new BSTree(new Leaf(), elt, new Leaf());
    }

    public FiniteSets remove(int elt) {
        return new Leaf();
    }

    public FiniteSets union(FiniteSets u) {
        return u;
    }

    public FiniteSets inter(FiniteSets u) {
        return new Leaf();
    }

    public FiniteSets diff(FiniteSets u) {
        return u;
    }

    public boolean equal(FiniteSets u) {
        return u.isEmptyHuh();
    }

    public boolean subset(FiniteSets u) {
        return u.isEmptyHuh();
    }

}
