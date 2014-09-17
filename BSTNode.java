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

    public FiniteSets empty() {
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
//                if (!left.isEmptyHuh()) {
//                    left.add(num);
//                } else {
//                    left = new BSTNode(new Leaf(), num, new Leaf());
//                }
        } //            else if (!right.isEmptyHuh()) {
        //                right.add(num); 
        else {
            return new BSTNode(this.left, this.data, this.right.add(num));
//                right = new BSTNode(new Leaf(), num, new Leaf());
        }
    }

    public FiniteSets remove(int elt) {
        if (elt == this.data){
// fix return value for this case             
            return this.left;
        } else if (elt < this.data){
            return new BSTNode(left.remove(elt), this.data,right);
        }
        else{
            return new BSTNode(right, this.data,right.remove(elt));
        }
//        if (num == data) {
//            return deleteRoot();
//        } else {
//            if (num < data) {
//                if (left != null) {
//                    left = left.remove(num);
//                }
//            } else {
//                if (right != null) {
//                    right = right.remove(num);
//                }
//            }
//            return this;
//        }
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
        if (u.member(this.data)) {
            return new BSTNode(this.left.inter(u), data, this.right.inter(u));
        } else {
            return 
            
    
        }
    }

    public FiniteSets diff(FiniteSets u) {
        if (!u.member(data)){
            return new BSTNode(this.left.diff(u), data, this.right.diff(u));
        }
        else{
            return 
        }
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
