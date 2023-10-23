package org.practiceproblem;

import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
       this. next=null;
    }
}
public class LinkedList
{
    Node head;
    private int size;

    public LinkedList()
    {

        this.size=0;
    }

    public  boolean isEmpty()
    {
        return size==0;
    }
    public void addFirst(int data)
    {
         Node node= new Node(data);
         if(head==null)
             head= node;
         else {
             node.next = head;
             head = node;
         }
       size++;
    }

    public void addLast(int data)
    {
        Node node= new Node(data);
        if(head==null)
            head= node;
        else {
          Node temp=head;
          while (temp.next!=null)
              temp=temp.next;
          temp.next=node;
        }
       size++;
    }

    public int get(int index)
    {
        if(index<0&&index>=size)
            throw  new IndexOutOfBoundsException("Invalid index");
        Node curr=head;

        for(int i=0;i<index;i++)
            curr=curr.next;

        return curr.data;


    }

    public  void removeValue(int value)
    {
         Node prev=null;
         Node curr=head;
         while (curr!=null)
         {
            if(curr.data==value)
            {
                if(prev==null)
                    head=curr.next;
                else
                    prev.next=curr.next;

                size--;
            }

            prev=curr;
            curr=curr.next;
         }
    }

    public  void printList()
    {
        Node curr=head;
        if(isEmpty())
            System.out.println("List is EMPTY");
        while (curr!=null)
        {
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println();
        System.out.println("SIZE IS "+size);
    }

    public  void reverseLinList()
    {
        Node prev=null;
        Node curr=head;
        Node next=null;
        while (curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;

        }
        head=prev;
    }

    public  void reverseRecursive()
    {
        head=recursiveUtil(head,null);
    }

    private Node recursiveUtil(Node curr, Node prev)
    {
        if(curr==null)
            return prev;
        Node next=curr.next;
        curr.next=prev;
        return recursiveUtil(next,curr);
    }

    public  Node findMiddleElement()
    {
        if(head==null)
            return null;
        Node fast=head;
        Node slow=head;
        while (fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;
    }

    public void removeNthNode(int n)
    {
        if(head==null)
            return;
        if(n==1)
        {
            head=head.next;
            return;
        }
        Node prevNpde=null;
        Node currNode=head.next;
        for(int i=2;i<n;i++)
        {
            if(currNode==null)
                return;
            prevNpde=currNode;
            currNode=currNode.next;
        }
        if(currNode==null)
            return;
        prevNpde.next=currNode.next;
    }
    public void swapNode()
    {
        Node dummy=new Node(0);
        dummy.next=head;
        Node current=dummy;
        while (current.next!=null&&current.next.next!=null)
        {
            Node first=current.next;
            Node seccond=current.next.next;
            first.next=seccond.next;
            current.next=seccond;
            current.next.next=first;
            current=current.next.next;
        }
        head= dummy.next;
    }

    public static void main(String[] args) {
        LinkedList linkedList= new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.printList();
        linkedList.swapNode();
        System.out.println("After SWAP");
        linkedList.printList();
        System.out.println(linkedList.get(3));
        linkedList.removeValue(30);
        linkedList.printList();
        linkedList.addLast(70);
        linkedList.printList();
        linkedList.reverseLinList();
        linkedList.printList();
        System.out.println(linkedList.findMiddleElement().data);
       linkedList.removeNthNode(3);
       linkedList.printList();

    }
}
