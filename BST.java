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
public class BST implements FiniteSets{
    protected BSTNode root;

    //Returns a new BST with nothing in it 
    public BST() {
        root = null;
    }

//    public BST(int data, BST left, BST right) {
//        BSTNode r = new BSTNode(data);
//        root = r;
//        this.left = left;
//        this.right = right;
//    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int num) {
        if (this.isEmpty()){
            root = new BSTNode(num);
        } else {
            root.insert(num);
        }
    }
    
    public void delete(int i) {
        if (isEmpty()) {
            root.delete(i);
        }
        
    }
    
    public boolean member(BST t, int i) {
        if (t.isEmpty()){
            return false;
        }
        return root.member(i);
    }
}
