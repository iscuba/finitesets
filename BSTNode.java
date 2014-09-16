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
public class BSTNode {
    BSTNode left, right;
    int data;
    
    //constructor for a new node wihout a data input results in a node with 
    //  data = 0
    public BSTNode(){
        left = null;
        right = null;
        data = 0;
    }
    // constructor when usr knows the data 
    public BSTNode(int n){
        left = null;
        right = null;
        data = n;
    }
    
    public void insert(int num){
        if(num == data) {
            data = num;
        }
        if(num < data){
            if (left != null){
                left.insert(num); 
            }
            else { 
                left = new BSTNode(num); 
            }
        }
        else if (right != null){
            right.insert(num);
        } else {
            right = new BSTNode(num);
        }
    }
    
    public BSTNode delete(int num){
        if(num == data){
            return deleteRoot();
        }
        else{ 
            if(num < data){
                if(left != null){
                    left = left.delete(num);
                } 
            } else {
                if (right != null){
                    right = right.delete(num);
                }
               }
           return this;  
        }
    }
    
    public BSTNode deleteRoot(){
        if(left != null){
            data = left.max();
            left = left.deleteMax();
            return this;
        }
        else { 
            return right;
        }
    }
    
    public boolean member(int num){
        if( num == data){
            return true;
        }
        if(num < data){
            if(left == null)
                return false;
            else {
                return left.member(num); 
            }
        } 
        else {
            if (right == null){
                return false;
            }
            else{
                return right.member(num);
            }
        }
    }
    
    public BSTNode deleteMax() {
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
    
    public void setRight(BSTNode n){ 
        right = n;
    }
    
    public void setLeft(BSTNode n){
        left = n;
    }
    
    public void setData(int n){
        data = n;
    }
    
    public BSTNode getLeft(){
        return left;
    }
    
    public BSTNode getRight(){
        return right;
    }
    
    public int getData(){
        return data;
    }
}
