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
    int data, count;

    public BSTNode(FiniteSets left, int n, FiniteSets right) {
        this.left = left;
        this.right = right;
        data = n;
    }

    public FiniteSets empty() {
        return new Leaf();
    }

    public int cardinality() {
        if (this.isEmptyHuh()) {
            return 0;
        } else {
            return count + 1;
        }
    }

    public boolean isEmptyHuh() {
        return false;
    }

    public FiniteSets add(int num) {
        if (num == data) {
            return this;
        } else {
            if (num < data) {
                if (!left.isEmptyHuh()) {
                    left.add(num);
                } else {
                    left = new BSTNode(new Leaf(), num, new Leaf());
                    count++;
                }
            } else if (!right.isEmptyHuh()) {
                right.add(num);
            } else {
                right = new BSTNode(new Leaf(), num, new Leaf());
                count++;
            }
            return this;
        }

    }

    public FiniteSets remove(int num) {
        if (num == data) {
            return deleteRoot();
        } else {
            if (num < data) {
                if (left != null) {
                    left = left.remove(num);
                }
            } else {
                if (right != null) {
                    right = right.remove(num);
                }
            }
            return this;
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
        return this.left.union(this.right.union(u)).add(data);

    }

    public FiniteSets inter(FiniteSets u) {
        if(u.member(this.data))
            return new BSTNode(this.left.inter(u), data,this.right.inter(u));
        else 
            return 
            
    }

    public FiniteSets diff(FiniteSets u) {

    }

    public boolean equal(FiniteSets u) {

    }

    public boolean subset(FiniteSets u) {

    }

    public FiniteSets deleteRoot() {
        if (left != null) {
            data = left.max();
            left = left.deleteMax();
            return this;
        } else {
            return right;
        }
    }

    public FiniteSets deleteMax() {
        if (right == null) {
            return left;
        } else {
            right = right.deleteMax();
            return this;
        }
    }

    public int max() {
        if (right == null) {
            return data;
        } else {
            return right.max();
        }
    }

    public void setRight(BSTNode n) {
        right = n;
    }

    public void setLeft(BSTNode n) {
        left = n;
    }

    public void setData(int n) {
        data = n;
    }

    public FiniteSets getLeft() {
        return left;
    }

    public FiniteSets getRight() {
        return right;
    }

    public int getData() {
        return data;
    }
}
