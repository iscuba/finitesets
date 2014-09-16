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
public class BST {
    protected BSTNode root, current;
    protected BST left, right;

    //Returns a new BST with nothing in it 
    public BST() {
        root = null;
    }

    public BST(int data, BST left, BST right) {
        BSTNode r = new BSTNode(data);
        root = r;
        this.left = left;
        this.right = right;
    }

    public boolean isEmpty(BST tree) {
        return root == null;
    }

    public BST insert(BSTNode node) {
        if(node.data <= current.data){
            current = current.left;
            insert(current);
            if(node.data > current.){
                
            }
        }

    }

}
