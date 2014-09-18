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
public class BSTNode implements FiniteSets {

    FiniteSets left, right;
    int data;

    public BSTNode(FiniteSets left, int n, FiniteSets right) {
        this.left = left;
        this.right = right;
        data = n;
    }

    public static FiniteSets empty() {
        return new Leaf();
    }

    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public FiniteSets add(int num) {
        if (num == data) {
            return this;
        } else if (num < data) {
            return new BSTNode(this.left.add(num), this.data, this.right);
        } else {
            return new BSTNode(this.left, this.data, this.right.add(num));
        }
    }

    public FiniteSets remove(int elt) {
        if (elt == this.data) {
// fix return value for this case             
            return this.left.union(this.right);
        } else if (elt < this.data) {
            return new BSTNode(left.remove(elt), this.data, right);
        } else {
            return new BSTNode(left, this.data, right.remove(elt));
        }
    }

    public boolean member(int elt) {
        if (elt == data) {
            return true;
        } else if (elt < data) {
            return left.member(elt);

        } else {
            return right.member(elt);
        }
    }

    public FiniteSets union(FiniteSets u) {
        return left.union(right.union(u)).add(data);

    }

    public FiniteSets inter(FiniteSets u) {
        if (u.member(this.data)) {
            return new BSTNode(this.left.inter(u), data, this.right.inter(u));
        } else {
            return left.inter(u).union(right.inter(u));
        }
    }

    public FiniteSets diff(FiniteSets u) {
        if (u.member(data)) {
            return left.diff(u).union(right.diff(u));
        } else {
            return new BSTNode(left.diff(u), data, right.diff(u));
        }
    }

    public boolean equal(FiniteSets u) {
        return (subset(u) && u.subset(this));
    }

    public boolean subset(FiniteSets u) {
        return (u.member(data) && left.subset(u) && right.subset(u));

    }
}
