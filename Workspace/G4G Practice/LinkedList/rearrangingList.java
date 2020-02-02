{

import java.util.*;
import java.lang.*;
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
class Rearr
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);
            
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }
            
            GfG gfg = new GfG();
            gfg.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void addToTheLast(Node node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while(temp.next != null)
                  temp = temp.next;
                temp.next = node;
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class GfG
{
    public static void rearrange(Node head)
    {
        if(head.next==null){
            return;
        }
        Node evenStart=null,evenEnd=null,oddStart=null,oddEnd=null;
        Node temp = head;
        int index = 0;
        while(temp!=null){
            if(index%2==0){
                if(evenStart==null){
                    evenStart=temp;
                    evenEnd=temp;
                }else{
                    evenEnd.next=temp;
                    evenEnd=temp;
                }
            }else{
                if(oddStart==null){
                    oddStart=temp;
                    oddEnd=temp;
                }else{
                    oddEnd.next=temp;
                    oddEnd=temp;
                }
            }
            temp=temp.next;
            index++;
        }
        oddEnd.next = null;
		rev(oddStart);
		oddStart.next = null;
		evenEnd.next = oddEnd;
    }

    
    private static void rev(Node head){
        if(head.next==null){
            return;
        }
        rev(head.next);
        head.next.next=head;
    }
    
}

