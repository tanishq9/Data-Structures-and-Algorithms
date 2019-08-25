
/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
class Node {
   int data;
   Node next;
  Node(int data) {
      this.data = data;
  }
}
public class LinkedList
{
    Node head;
    // Member Methods
}*/
/* This is method only submission.
You only need to complete the below method.*/
class GfG
{
    void compute(LinkedList l)
    {
        Node tail=getTail(l.head);
        reverse(l,tail);
        //display(l.head);
        reorder(l);
        //display(l.head);
        tail=getTail(l.head);
        reverse(l,tail);
        //display(l.head);
    }
    
    void display(Node node){
        Node temp=node;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    
    Node getTail(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    
    void reverse(LinkedList l,Node tail){
        rev(l.head);
        Node temp=l.head;
        l.head=tail;
        tail=temp;
        tail.next=null;
        return;
    }
    void rev(Node head){
        if(head.next==null){
            return;
        }
        rev(head.next);
        head.next.next=head;
    }
    void reorder(LinkedList l){
        Node node=l.head;
        int max = node.data;
        while(node.next!=null){
            int val=node.next.data;
            if(Math.max(node.next.data,max)>val){
                node.next=node.next.next;
            }else{
                max=node.next.data;
                node=node.next;
            }
        }
    }
}
  
