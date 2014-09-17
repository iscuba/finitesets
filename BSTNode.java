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
            return this.left.union(this.right);
        } else if (elt < this.data){
            return new BSTNode(left.remove(elt), this.data,right);
        }
        else{
            return new BSTNode(left, this.data,right.remove(elt));
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
            return left.inter(u).union(right.inter(u));
        }
    }

    public FiniteSets diff(FiniteSets u) {
        if (u.member(data)){
            return left.diff(u).union(right.diff(u));
        } 
        else{
            return new BSTNode(left.diff(u), data, right.diff(u));  
        }
    }

    public boolean equal(FiniteSets u) {
        if (u.member(data))
    }

    public boolean subset(FiniteSets u) {
        if(this.equal(u))
            return true;
        else if{
            
        }

    }

}
