package org.practiceproblem;

public class BinarySearchTree
{
    private static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }


    }
    private Node root;
    public  BinarySearchTree()
    {
        this.root=null;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    public Node insertNode(Node root,int data)
    {
           if(root==null)
           {
               root= new Node(data);
               return root;
           }
           if(data< root.data)
               root.left=insertNode(root.left,data);
           else {
               if(data>root.data)
               {
                   root.right=insertNode(root.right,data);
               }
           }

           return root;
    }
    public void infix()
    {
        infixTraversal(root);
        System.out.println();
    }
    public void infixTraversal(Node root)
    {
        if(root!=null)
        {
            infixTraversal(root.left);
            System.out.print(root.data+" ");
            infixTraversal(root.right);
        }
    }

    public void postfix()
    {
        postfixTraversal(root);
        System.out.println();
    }
    public void postfixTraversal(Node root)
    {
        if(root!=null)
        {
            postfixTraversal(root.left);
            postfixTraversal(root.right);
            System.out.print(root.data+" ");
        }
    }

    public void prefix()
    {
        prefixTraversal(root);
        System.out.println();
    }

    public void prefixTraversal(Node root)
    {
        System.out.print(root.data+" ");
        prefixTraversal(root.left);
        postfixTraversal(root.right);
    }

    public Node serach(int data)
    {
        return serachData(root,data);
    }

    private Node serachData(Node root,int data) {
        if(root.data==data)
            return root;
        if(root.data>data)
            serachData(root.left,data);

        return serachData(root.right,data);
    }
    public void delete(int data)
    {
       root= delete(root,data);
    }

    private Node delete(Node root, int data) {
        if(root==null)
            return null;
        if(data<root.data)
            root.left=delete(root.left,data);
        else if (data>root.data)
            root.right=delete(root.right,data);
        else if (root.data==data)
        {
            if(root.left==null&&root.right==null)
                root=null;
            else if (root.left==null)
            {
                root=root.right;
            } else if (root.right==null)
            {
                root=root.left;
            } else {

                Node minNode=findMinNode(root.right);
                root.data=minNode.data;
                root.right=delete(root.right,minNode.data);

            }

        }

       return root;
    }

    private Node findMinNode(Node root)
    {
        while (root.left!=null)
            root=root.left;
        return root;
    }

    
    public  int heightOfTree()
    {
       return heightOfTree(root);
    }

    private  int heightOfTree(Node root)
    {
        if(root==null)
            return -1;
        else
        {
            int leftHeight=heightOfTree(root.left);
            int rightHeight=heightOfTree(root.right);

            return Math.max(leftHeight,rightHeight)+1;
        }
    }
   public boolean isValidBinaryTree()
   {
      return isValidBinaryTree( root,Integer.MIN_VALUE,Integer.MAX_VALUE);
   }

    private boolean isValidBinaryTree(Node root, int minValue, int maxValue)
    {
        if(root==null)
            return true;
        if(root.data<=minValue||root.data>=maxValue)
            return false;

        return isValidBinaryTree(root.left,minValue,root.data)&&isValidBinaryTree(root.right,root.data,maxValue);

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.println(bst.isValidBinaryTree());
        System.out.println("Inorder Traversal");
        bst.infix();
        System.out.println(bst.heightOfTree());
        System.out.println(bst.serach(80).data);
        bst.delete(30);
        bst.infix();
    }
}
