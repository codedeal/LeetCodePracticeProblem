package org.RevisionPractice;

import java.util.Stack;

class Node
{
    int val;
    Node left,right;
    public Node(int val)
    {
        this.val=val;
        left=null;
        right=null;

    }
}
class  BST
{
    Node root;
    public  BST()
    {
        root=null;
    }
    public void  insert(int val)
    {
      root=  insertNode(root,val);
    }
    private Node insertNode(Node node,int val)
    {
        if (node == null) {
            node = new Node(val);
            return node;
        }
        if (val < node.val) {
            node.left = insertNode(node.left, val);
        } else if (val > node.val) {
            node.right = insertNode(node.right, val);
        }
        return node;
    }
    public void zigZagTraversal()
    {
        if(root==null)
            return;
        Stack<Node>currentLevel= new Stack<>();
        Stack<Node>nextLevel= new Stack<>();
        boolean leftToRight=true;
        currentLevel.push(root);
        while (!currentLevel.isEmpty())
        {
            Node node=currentLevel.pop();
            System.out.print(node.val+"  ");
            if(leftToRight)
            {
                if(node.left!=null)
                    nextLevel.push(node.left);
                if(node.right!=null)
                    nextLevel.push(node.right);

            }
            else {
                if(node.right!=null)
                    nextLevel.push(node.right);
                if(node.left!=null)
                    nextLevel.push(node.left);
            }
            if(currentLevel.isEmpty())
            {
                leftToRight=!leftToRight;
                Stack<Node>temp=currentLevel;
                currentLevel=nextLevel;
                nextLevel=temp;
            }
        }
    }
    public void printBST(Node node)
    {
        if(node==null)
            return;
        printBST(node.left);
        System.out.print(node.val+" ");
        printBST(node.right);
    }
}
public class ZigZagTraversal
{
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        bst.printBST(bst.root);
        System.out.println("-------------");
        bst.zigZagTraversal();

      // bst.printBST(bst.root);
    }
}
